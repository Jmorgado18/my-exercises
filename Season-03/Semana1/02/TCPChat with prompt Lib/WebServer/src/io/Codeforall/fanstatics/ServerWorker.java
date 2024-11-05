package io.Codeforall.fanstatics;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ServerWorker implements Runnable {
    private Socket clientSocket;
    private PrintWriter out;
    private List<ServerWorker> clients;
    private String clientName;

    // Lista de usuários silenciados
    private final Set<String> mutedUsers = new HashSet<>();

    // Limite do histórico de mensagens
    private static final int HISTORY_LIMIT = 50;
    private static final List<String> messageHistory = new ArrayList<>();
    private static final String HISTORY_FILE = "historico_mensagens.txt"; // Caminho do arquivo para o histórico

    // Status do usuário
    private String status = "Disponível"; // Estado inicial

    // Cor do texto do cliente
    private String textColor = "preto"; // Cor padrão do texto

    public ServerWorker(Socket clientSocket, List<ServerWorker> clients) {
        this.clientSocket = clientSocket;
        this.clients = clients;
    }

    @Override
    public void run() {
        try {
            // Criando o prompt para ler entradas
            Prompt prompt = new Prompt(System.in, System.out);

            out = new PrintWriter(clientSocket.getOutputStream(), true);

            // Solicita o nome do cliente com o Prompt
            StringInputScanner askName = new StringInputScanner();
            askName.setMessage("Por favor, insira seu nome:");
            clientName = prompt.getUserInput(askName);

            while (isNameTaken(clientName)) {
                out.println("Nome já está em uso. Por favor, escolha outro nome:");
                clientName = prompt.getUserInput(askName);  // Usando o Prompt para solicitar o nome novamente
            }

            out.println("Bem-vindo, " + clientName + "! Você está conectado.");

            synchronized (clients) {
                clients.add(this);
            }

            String message;
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            while ((message = reader.readLine()) != null) {
                if (message.startsWith("/quit")) {
                    break;
                } else if (message.startsWith("/whisper ")) {
                    handleWhisper(message);
                } else if (message.startsWith("/list")) {
                    listUsers();
                } else if (message.startsWith("/changename")) {
                    changename(prompt);  // Passa o prompt para alterar o nome
                } else if (message.startsWith("/history")) {
                    showHistory();
                } else if (message.startsWith("/mute ")) {
                    handleMute(message);
                } else if (message.startsWith("/status ")) {
                    handleStatus(message, prompt);  // Passa o prompt para alterar o status
                } else {
                    broadcast(clientName + " (" + textColor + "): " + message, this);
                    addToHistory(clientName + ": " + message);  // Adiciona ao histórico
                }
            }
        } catch (IOException e) {
            System.err.println("Erro de I/O: " + e.getMessage());
        } finally {
            try {
                synchronized (clients) {
                    clients.remove(this);
                    broadcast(clientName + " saiu do chat.", this);
                }
                clientSocket.close();
            } catch (IOException e) {
                System.err.println("Erro ao fechar o socket: " + e.getMessage());
            }
        }
    }

    // Alterando o status do usuário com o Prompt
    private void handleStatus(String message, Prompt prompt) {
        String[] tokens = message.split(" ", 2);
        if (tokens.length < 2) {
            out.println("Uso correto: /status <disponível/ausente/ocupado>");
            return;
        }
        status = tokens[1].toLowerCase();
        out.println("Seu status foi alterado para: " + status);
    }

    // Mudando o nome do usuário com o Prompt
    private void changename(Prompt prompt) {
        StringInputScanner askNewName = new StringInputScanner();
        askNewName.setMessage("Por favor, insira novo nome:");
        String newName = prompt.getUserInput(askNewName);

        while (isNameTaken(newName)) {
            out.println("Nome já está em uso. Por favor, escolha outro nome:");
            newName = prompt.getUserInput(askNewName);  // Usando o Prompt para solicitar o nome novamente
        }
        out.println("Seu nome foi alterado para: " + newName);
        broadcast(clientName + " mudou seu nome para " + newName, this);
        clientName = newName;
    }

    private boolean isNameTaken(String name) {
        synchronized (clients) {
            for (ServerWorker client : clients) {
                if (client.clientName.equalsIgnoreCase(name)) {
                    return true; // Nome já está em uso
                }
            }
        }
        return false; // Nome disponível
    }

    private void broadcast(String message, ServerWorker sender) {
        synchronized (clients) {
            for (ServerWorker client : clients) {
                if (client != sender && !client.isMuted(sender.clientName)) {
                    client.out.println(message);
                }
            }
        }
    }

    private void handleWhisper(String message) {
        String[] tokens = message.split(" ", 3);
        if (tokens.length < 3) {
            out.println("Uso correto: /whisper <nome> <mensagem>");
            return;
        }

        String targetName = tokens[1];
        String privateMessage = tokens[2];
        ServerWorker targetClient = null;

        synchronized (clients) {
            for (ServerWorker client : clients) {
                if (client.clientName.equals(targetName)) {
                    targetClient = client;
                    break;
                }
            }
        }

        if (targetClient != null) {
            targetClient.out.println("[Whisper de " + clientName + "]: " + privateMessage);
        } else {
            out.println("Usuário " + targetName + " não encontrado.");
        }
    }

    private void listUsers() {
        out.println("Usuários conectados:");
        synchronized (clients) {
            for (ServerWorker client : clients) {
                out.println(client.clientName + " (" + client.status + ")");
            }
        }
    }

    private void showHistory() {
        out.println("Últimas mensagens:");
        synchronized (messageHistory) {
            for (String message : messageHistory) {
                out.println(message);
            }
        }
    }

    private void addToHistory(String message) {
        synchronized (messageHistory) {
            messageHistory.add(message);
            if (messageHistory.size() > HISTORY_LIMIT) {
                messageHistory.remove(0); // Remove a mensagem mais antiga se o limite for excedido
            }
        }
        saveHistoryToFile(); // Salva o histórico em um arquivo
    }

    private void saveHistoryToFile() {
        try (FileWriter writer = new FileWriter(HISTORY_FILE, true)) {
            synchronized (messageHistory) {
                for (String message : messageHistory) {
                    writer.write(message + "\n");
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao salvar o histórico: " + e.getMessage());
        }
    }

    private void handleMute(String message) {
        String[] tokens = message.split(" ", 2);
        if (tokens.length < 2) {
            out.println("Uso correto: /mute <nome>");
            return;
        }

        String userToMute = tokens[1];
        mutedUsers.add(userToMute);
        out.println("Você silenciou " + userToMute);
    }

    private boolean isMuted(String userName) {
        return mutedUsers.contains(userName);
    }
}

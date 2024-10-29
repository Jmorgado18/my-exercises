package io.Codeforall.fanstatics;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
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
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new PrintWriter(clientSocket.getOutputStream(), true);

            // Solicita o nome do cliente
            out.println("Por favor, insira seu nome:");
            clientName = in.readLine();
            while (isNameTaken(clientName)) {
                out.println("Nome já está em uso. Por favor, escolha outro nome:");
                clientName = in.readLine();
            }
            out.println("Bem-vindo, " + clientName + "! Você está conectado.");

            synchronized (clients) {
                clients.add(this);
            }

            String message;
            while ((message = in.readLine()) != null) {
                if (message.startsWith("/quit")) {
                    break;
                } else if (message.startsWith("/whisper ")) {
                    handleWhisper(message);
                } else if (message.startsWith("/list")) {
                    listUsers();
                } else if (message.startsWith("/changename")) {
                    changename();
                } else if (message.startsWith("/history")) {
                    showHistory();
                } else if (message.startsWith("/mute ")) {
                    handleMute(message);
                } else if (message.startsWith("/status ")) {
                    handleStatus(message);
                } else if (message.startsWith("/typing")) {
                    notifyTyping();
                } else if (message.startsWith("/help")) {
                    detailedHelp(message);
                } else if (message.startsWith("/background ")) {
                    handleBackgroundChange(message);
                } else if (message.startsWith("/color ")) {
                    changeColor(message);
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

    private void notifyTyping() {
        broadcast(clientName + " está digitando...", this);
    }

    private void handleStatus(String message) {
        String[] tokens = message.split(" ", 2);
        if (tokens.length < 2) {
            out.println("Uso correto: /status <disponível/ausente/ocupado>");
            return;
        }
        status = tokens[1].toLowerCase();
        out.println("Seu status foi alterado para: " + status);
    }

    private void changeColor(String message) {
        String[] tokens = message.split(" ", 2);
        if (tokens.length < 2) {
            out.println("Uso correto: /color <cor>");
            return;
        }

        String newColor = tokens[1].toLowerCase();
        textColor = newColor; // Atualiza a cor do texto
        out.println("A cor do seu texto foi alterada para: " + textColor);
    }

    private void detailedHelp(String message) {
        String[] tokens = message.split(" ", 2);

        // Se nenhum comando for especificado, mostra todos os comandos
        if (tokens.length < 2) {
            out.println("Comandos disponíveis:");
            out.println("/whisper <nome> <mensagem> - Envia uma mensagem privada para um usuário específico.");
            out.println("/changename - Altera seu nome de usuário.");
            out.println("/list - Lista todos os usuários conectados.");
            out.println("/quit - Sai da sala de chat.");
            out.println("/history - Mostra as últimas mensagens do chat.");
            out.println("/mute <nome> - Silencia um usuário específico.");
            out.println("/status <disponível/ausente/ocupado> - Define seu status.");
            out.println("/typing - Indica que você está digitando.");
            out.println("/background <cor_hexadecimal> - Altera a cor de fundo do chat.");
            out.println("/color <cor> - Altera a cor do seu texto.");
            return;
        }

        String command = tokens[1];
        switch (command) {
            case "whisper":
                out.println("/whisper <nome> <mensagem> - Envia uma mensagem privada para um usuário específico.");
                break;
            case "changename":
                out.println("/changename - Altera seu nome de usuário.");
                break;
            case "list":
                out.println("/list - Lista todos os usuários conectados.");
                break;
            case "quit":
                out.println("/quit - Sai da sala de chat.");
                break;
            case "history":
                out.println("/history - Mostra as últimas mensagens do chat.");
                break;
            case "mute":
                out.println("/mute <nome> - Silencia um usuário específico.");
                break;
            case "status":
                out.println("/status <disponível/ausente/ocupado> - Define seu status.");
                break;
            case "background":
                out.println("/background <cor_hexadecimal> - Altera a cor de fundo do chat.");
                break;
            case "color":
                out.println("/color <cor> - Altera a cor do seu texto.");
                break;
            default:
                out.println("Comando desconhecido. Use /help para ver os comandos disponíveis.");
                break;
        }
    }

    private void handleBackgroundChange(String message) {
        String[] tokens = message.split(" ", 2);
        if (tokens.length < 2) {
            out.println("Uso correto: /background <cor_hexadecimal>");
            return;
        }

        String color = tokens[1];
        // Aqui você pode implementar a lógica para mudar o fundo, se estiver usando um sistema que suporte isso.
        out.println("Cor de fundo alterada para: " + color);
    }

    private void changename() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        out.println("Por favor, insira novo nome:");
        String newName = in.readLine();
        while (isNameTaken(newName)) {
            out.println("Nome já está em uso. Por favor, escolha outro nome:");
            newName = in.readLine();
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

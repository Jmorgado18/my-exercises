package io.Codeforall.fanstatics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;



public class ServerWorker implements Runnable {
    private Socket clientSocket;
    private PrintWriter out;
    private List<ServerWorker> clients; // Alterado para não ser estático
    private String clientName;

    public ServerWorker(Socket clientSocket, List<ServerWorker> clients) {
        this.clientSocket = clientSocket;
        this.clients = clients; // Atribuindo a lista de clientes corretamente
    }

    @Override
    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new PrintWriter(clientSocket.getOutputStream(), true);

            // Solicita o nome do cliente
            out.println("Por favor, insira seu nome:");
            clientName = in.readLine();
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
                } else if (message.startsWith("/help")) {
                    helpHandler();

                } else {
                    broadcast(clientName + ": " + message, this);
                }
            }
        } catch (IOException e) {
            System.err.println("Erro de I/O: " + e.getMessage());
        } finally {
            try {
                synchronized (clients) {
                    clients.remove(this);
                    broadcast(clientName + " saiu do chat.", this); // Informa todos que o cliente saiu
                }
                clientSocket.close(); // Fechar o socket ao sair
            } catch (IOException e) {
                System.err.println("Erro ao fechar o socket: " + e.getMessage());
            }
        }
    }

    private void helpHandler() {
        out.println(" Digite /whisper para uma mensagem privada ");
        out.println((" Digite /help para ajuda"));
        out.println("Digite /changename para mudar o nome de utilizador");
        out.println("Digite /list para listar todos os utilizadores presentes no chat");
        out.println("Digite /quit para sair da sala de chat");
    }

    private void changename() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        out.println("Por favor, insira novo nome:");
        clientName = in.readLine();
        out.println(("Novo nome : " + clientName));
    }

    private void broadcast(String message, ServerWorker sender) {
        synchronized (clients) {
            for (ServerWorker client : clients) {
                if (client != sender) {
                    client.out.println(message);
                }
            }
        }
    }

    // Método para enviar uma mensagem privada para um usuário específico
    private void handleWhisper(String message) {
        String[] tokens = message.split(" ", 3); // Divide em /whisper, nome, e mensagem
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

    // Método para listar todos os usuários conectados
    private void listUsers() {
        out.println("Usuários conectados:");
        synchronized (clients) {
            for (ServerWorker client : clients) {
                out.println("- " + client.clientName);
            }
        }
    }
}
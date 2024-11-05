package io.Codeforall.fanstatics;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class WebServer {
    private static final List<ServerWorker> clients = new ArrayList<>();
    private static final int port = 8085;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Servidor iniciado na porta " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Connection established from " + clientSocket.getInetAddress());

                // Cria uma nova instância de ServerWorker
                ServerWorker worker = new ServerWorker(clientSocket, clients);
                // Inicia uma nova thread com o ServerWorker
                new Thread(worker).start();
            }
        } catch (IOException e) {
            System.err.println("Erro ao iniciar o servidor: " + e.getMessage());
        }
    }
}
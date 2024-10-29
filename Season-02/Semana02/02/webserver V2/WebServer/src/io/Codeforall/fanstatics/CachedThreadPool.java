package io.Codeforall.fanstatics;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPool {
    private static final List<ServerWorker> clients = new ArrayList<>();
    private static final int port = 8085;

    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newCachedThreadPool(); // Pool de threads variável

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Servidor iniciado na porta " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Conexão estabelecida com " + clientSocket.getInetAddress());

                ServerWorker worker = new ServerWorker(clientSocket, clients);
                threadPool.execute(worker); // Envia a tarefa para a pool de threads variável
            }
        } catch (IOException e) {
            System.err.println("Erro ao iniciar o servidor: " + e.getMessage());
        } finally {
            threadPool.shutdown(); // Fecha o pool de threads ao encerrar o servidor
        }
    }
}

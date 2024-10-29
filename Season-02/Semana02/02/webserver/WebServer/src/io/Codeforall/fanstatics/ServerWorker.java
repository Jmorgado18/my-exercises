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
    private static List<PrintWriter> clientOutputs; // Referência compartilhada com o ChatServer

    public ServerWorker(Socket clientSocket, List<PrintWriter> clientOutputs) {
        this.clientSocket = clientSocket;
        ServerWorker.clientOutputs = clientOutputs; // Inicializando a lista
    }

    @Override
    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            
            synchronized (clientOutputs) {
                clientOutputs.add(out);
            }
            
            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("Mensagem recebida: " + message);
                broadcast(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            synchronized (clientOutputs) {
                clientOutputs.remove(out);
            }
            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // Método para enviar a mensagem para todos os clientes conectados
    private void broadcast(String message) {
        synchronized (clientOutputs) {
            for (PrintWriter writer : clientOutputs) {
                writer.println(message);
            }
        }
    }
}
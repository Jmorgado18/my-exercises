package io.Codeforall.fanstatics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import static jdk.incubator.vector.ByteVector.broadcast;

public class ServerWorker implements Runnable {
    private Socket clientSocket;
    private PrintWriter out;

    public void ServerWorker(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    public ServerWorker(Socket clientSocket) {
        this.clientSocket = clientSocket;
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
                System.out.println("Mensagem recebida :" + message);
                broadcast(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            synchronized ((clientOutputs)) {
                clientOutputs.remove(out);
            }
        }

    }

    private void broadcast(String message) {
        for (PrintWriter writer : clientOutputs) {
            writer.println(message);
        }
    }
}
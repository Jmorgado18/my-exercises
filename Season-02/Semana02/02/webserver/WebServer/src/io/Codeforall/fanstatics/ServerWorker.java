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
    private static List<PrintWriter> clientOutputs;
    private String name;

    public ServerWorker(Socket clientSocket, List<PrintWriter> clientOutputs) {
        this.clientSocket = clientSocket;
        ServerWorker.clientOutputs = clientOutputs;
    }

    @Override
    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new PrintWriter(clientSocket.getOutputStream(), true);

            out.println("Digite o seu nome : ");
            name=in.readLine();
            out.println("Seja bem vindo " + name);
            
            synchronized (clientOutputs) {
                clientOutputs.add(out);
            }
            
            String message;
            while ((message = in.readLine()) != null) {
                System.out.println(name +" : " +  message);
                broadcast(name + " : " + message,out);
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


    private void broadcast(String message, PrintWriter senderOut) {
        synchronized (clientOutputs) {

            for (PrintWriter writer : clientOutputs) {
                if(writer!=senderOut) {
                    writer.println(message);
                }
            }
        }
    }
}
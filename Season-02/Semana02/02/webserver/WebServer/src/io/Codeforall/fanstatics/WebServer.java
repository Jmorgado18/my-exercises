package io.Codeforall.fanstatics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class WebServer {
    private static final List<ServerWorker> clients= new ArrayList<>();
    private static final int port = 8085;
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(port);

        while(true){
        Socket clientSocket = serverSocket.accept();
        System.out.println("Connection established from " + clientSocket.getInetAddress());
        new Thread(new ServerWorker(clientSocket, clients));
        new Thread(worker).start();

      /*  PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));



            String inSTR = in.readLine();
            System.out.println(inSTR);

       */
        }


    }
}

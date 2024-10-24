package src;

import com.sun.jdi.connect.spi.Connection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;

public class Webserver {

    public static void main(String[] args) throws IOException {

        URL url = new URL("https://localhost:8080");
        URLConnection connection = url.openConnection();


        int portNumber = 8080;
        ServerSocket serverSocket = new ServerSocket(portNumber);

        Socket clientSocket = serverSocket.accept();
        System.out.println("Connecion on");

        while (true) {
            // Cria um PrintWriter para enviar mensagens ao cliente
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            // Cria um BufferedReader para ler mensagens enviadas pelo cliente
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            // Lê uma linha de mensagem enviada pelo cliente. Bloqueia a thread
            String message = in.readLine();









        }


    }
}

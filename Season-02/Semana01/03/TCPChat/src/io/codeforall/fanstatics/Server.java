package io.codeforall.fanstatics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {

        int portNumber = 8080; // Define o número da porta onde o servidor vai escutar as conexões

        // Cria um ServerSocket para escutar as conexões na porta especificada
        ServerSocket serverSocket = new ServerSocket(portNumber);

        // Aceita uma conexão de um cliente e cria um Socket para interagir com ele
        Socket clientSocket = serverSocket.accept();

        // Loop infinito para processar mensagens recebidas do cliente
        while(true) {

            // Cria um PrintWriter para enviar mensagens ao cliente
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            // Cria um BufferedReader para ler mensagens enviadas pelo cliente
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            // Lê uma linha de mensagem enviada pelo cliente
            String message = in.readLine();

            // Se a mensagem for "exit", fecha a conexão e encerra o programa
            if(message.equals("exit")) {
                clientSocket.close(); // Fecha o socket do cliente
                System.exit(0); // Encerra o programa
            }

            // Verifica se a mensagem não é nula
            if(!(message == null)) {
                System.out.println(message); // Imprime a mensagem recebida no console
                out.println(message); // Envia a mesma mensagem de volta ao cliente
            }
        }
    }
}

package io.codeforall.fanstatics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws IOException {

        // Cria um socket para se conectar ao servidor em localhost na porta 8080
        Socket clientSocket = new Socket("localhost", 8080);

        // Cria um PrintWriter para enviar mensagens ao servidor
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

        // Cria um BufferedReader para ler mensagens enviadas pelo servidor
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        // Loop infinito para permitir o envio contínuo de mensagens
        while(true) {
            // Lê a entrada do usuário usando Scanner e envia para o servidor
            out.println(new Scanner(System.in).nextLine());

            // Lê a resposta do servidor
            String serverMessage = in.readLine();

            // Verifica se a mensagem do servidor é nula (se sim : conexão fechada) se nao, imprime a mensagem correspondente
            System.out.println(serverMessage == null ? "CONNECTION CLOSED" : serverMessage);

        }
    }
}

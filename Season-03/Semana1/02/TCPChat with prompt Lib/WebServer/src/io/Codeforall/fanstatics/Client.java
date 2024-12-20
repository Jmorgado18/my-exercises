package io.Codeforall.fanstatics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicReference;
import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;

public class Client {

    public static void main(String[] args) {
        String host = "localhost";
        int port = 8085;
        AtomicReference<String> colorCode = new AtomicReference<>("\u001B[0m");

        try (Socket socket = new Socket(host, port);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            // Criando o Prompt e o scanner para capturar o nome do usuário
            Prompt prompt = new Prompt(System.in, System.out);
            StringInputScanner askName = new StringInputScanner();
            askName.setMessage("Digite o seu nome: ");
            String nome = prompt.getUserInput(askName);
            out.println(nome);

            System.out.println(in.readLine());

            Thread receiver = new Thread(() -> {
                try {
                    String serverMessage;
                    while ((serverMessage = in.readLine()) != null) {
                        if (serverMessage.startsWith("COLOR_CHANGE:")) {
                            colorCode.set(colorHexToAnsi(serverMessage.split(":")[1]));
                        } else {
                            System.out.println(colorCode + serverMessage + "\u001B[0m");
                        }
                    }
                } catch (IOException e) {
                    System.out.println("Erro ao ler do servidor: " + e.getMessage());
                }
            });
            receiver.start();

            String message;
            while (true) {
                // Usando o prompt para capturar as mensagens do usuário
                StringInputScanner askMessage = new StringInputScanner();
                askMessage.setMessage("Digite sua mensagem: ");
                message = prompt.getUserInput(askMessage);

                out.println(message);

                if (message.equalsIgnoreCase("/quit")) {
                    System.out.println("Você saiu do chat.");
                    break;
                }
            }

            receiver.join();

        } catch (IOException | InterruptedException e) {
            System.out.println("Erro ao conectar ao servidor: " + e.getMessage());
        }
    }

    private static String colorHexToAnsi(String hexColor) {
        int r = Integer.parseInt(hexColor.substring(1, 3), 16);
        int g = Integer.parseInt(hexColor.substring(3, 5), 16);
        int b = Integer.parseInt(hexColor.substring(5, 7), 16);
        return String.format("\u001B[38;2;%d;%d;%dm", r, g, b);
    }
}

package io.codeforall.bootcamp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Implementação de um servidor web simples e concorrente com múltiplas threads para atender vários clientes ao mesmo tempo.
 */
public class WebServerConcurrent {

    // Logger para exibir mensagens de log do servidor
    private static final Logger logger = Logger.getLogger(WebServerConcurrent.class.getName());

    // Caminho para os documentos que o servidor vai servir
    public static final String DOCUMENT_ROOT = "www/";

    // Porta padrão para o servidor
    public static final int DEFAULT_PORT = 8085;

    // Socket do servidor para aguardar conexões de clientes
    private ServerSocket bindSocket = null;

    // ExecutorService com um pool fixo de threads para gerenciar conexões de clientes simultâneas
    private ExecutorService executorService;
    private static final int THREAD_POOL_SIZE = 50;  // Tamanho do pool de threads

    // Método principal que inicia o servidor
    public static void main(String[] args) {

        try {
            // Obtém a porta a partir dos argumentos, ou usa a porta padrão
            int port = args.length > 0 ? Integer.parseInt(args[0]) : DEFAULT_PORT;

            // Cria uma instância do servidor e inicia a escuta na porta definida
            WebServerConcurrent webServer = new WebServerConcurrent();
            webServer.listen(port);

        } catch (NumberFormatException e) {
            // Exibe mensagem de erro se a porta fornecida não for um número válido
            System.err.println("Usage: WebServer [PORT]");
            System.exit(1);
        }
    }

    // Método para configurar o servidor e iniciar a escuta na porta especificada
    private void listen(int port) {

        try {
            // Inicializa o socket do servidor na porta especificada
            bindSocket = new ServerSocket(port);

            // Configura o pool de threads com o tamanho definido
            executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

            // Mensagem de log informando o endereço e porta do servidor
            logger.log(Level.INFO, "server bind to " + getAddress(bindSocket));

            // Inicia o processo de atendimento dos clientes
            serve(bindSocket);

        } catch (IOException e) {
            // Em caso de erro ao vincular à porta, exibe mensagem de erro e encerra o servidor
            logger.log(Level.SEVERE, "could not bind to port " + port);
            logger.log(Level.SEVERE, e.getMessage());
            System.exit(1);

        } finally {
            // Garante o desligamento do ExecutorService ao encerrar o servidor
            if (executorService != null) {
                executorService.shutdown();
            }
        }
    }

    // Método que mantém o servidor a aguardar novas conexões de clientes
    private void serve(ServerSocket bindSocket) {

        while (true) {
            try {
                // Aceita uma nova conexão de cliente e cria um socket específico para ela
                Socket clientSocket = bindSocket.accept();

                // Log de nova conexão com o endereço do cliente
                logger.log(Level.INFO, "new connection from " + getAddress(clientSocket));

                // Executa o tratamento do cliente em uma nova thread usando o pool de threads
                executorService.execute(new ClientHandler(clientSocket));

            } catch (IOException e) {
                // Log de erro caso ocorra uma falha ao aceitar uma conexão
                logger.log(Level.SEVERE, e.getMessage());
            }
        }
    }

    // Método para obter o endereço e porta do ServerSocket em formato de string
    private String getAddress(ServerSocket socket) {

        if (socket == null) {
            return null;
        }

        return socket.getInetAddress().getHostAddress() + ":" + socket.getLocalPort();
    }

    // Método para obter o endereço e porta de um socket cliente em formato de string
    private String getAddress(Socket socket) {
        return socket.getInetAddress().getHostAddress() + ":" + socket.getLocalPort();
    }

}

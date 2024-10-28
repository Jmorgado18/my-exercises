package io.codeforall.bootcamp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Single-threaded simple web server implementation
 */
public class WebServerConcurrent {

    private static final Logger logger = Logger.getLogger(WebServerConcurrent.class.getName());

    public static final String DOCUMENT_ROOT = "www/";
    public static final int DEFAULT_PORT = 8085;

    private ServerSocket bindSocket = null;

    private ExecutorService executorService;
    private static final int THREAD_POOL_SIZE = 50;

    public static void main(String[] args) {

        try {

            int port = args.length > 0 ? Integer.parseInt(args[0]) : DEFAULT_PORT;

            WebServerConcurrent webServer = new WebServerConcurrent();
            webServer.listen(port);

        } catch (NumberFormatException e) {

            System.err.println("Usage: WebServer [PORT]");
            System.exit(1);

        }
    }
    private void listen(int port) {

        try {

            bindSocket = new ServerSocket(port);
            executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

            logger.log(Level.INFO, "server bind to " + getAddress(bindSocket));

            serve(bindSocket);

        } catch (IOException e) {

            logger.log(Level.SEVERE, "could not bind to port " + port);
            logger.log(Level.SEVERE, e.getMessage());
            System.exit(1);

        } finally {
            if (executorService != null) {
                executorService.shutdown();
            }
        }
    }

    private void serve(ServerSocket bindSocket) {

        while (true) {

            try {
                Socket clientSocket = bindSocket.accept();
                logger.log(Level.INFO, "new connection from " + getAddress(clientSocket));
                executorService.execute(new ClientHandler(clientSocket));
            } catch (IOException e) {
                logger.log(Level.SEVERE, e.getMessage());
            }

        }
    }

    private String getAddress(ServerSocket socket) {

        if (socket == null) {
            return null;
        }

        return socket.getInetAddress().getHostAddress() + ":" + socket.getLocalPort();
    }

    private String getAddress(Socket socket) {
        return socket.getInetAddress().getHostAddress() + ":" + socket.getLocalPort();
    }


}

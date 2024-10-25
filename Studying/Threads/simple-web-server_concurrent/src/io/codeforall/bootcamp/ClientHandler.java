package io.codeforall.bootcamp;

import java.io.*;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClientHandler implements Runnable {

    private static final Logger logger = Logger.getLogger(ClientHandler.class.getName());
    private final Socket clientSocket;

    public ClientHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }


    @Override
    public void run() {
        try {
            handleClient();
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error handling client: " + e.getMessage());
        } finally {
            close();
        }
    }

    private void handleClient() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

        String requestHeaders = fetchRequestHeaders(in);
        if (requestHeaders.isEmpty()) {
            return;
        }

        String request = requestHeaders.split("\n")[0];
        String httpVerb = request.split(" ")[0];
        String resource = request.split(" ").length > 1 ? request.split(" ")[1] : null;

        logger.log(Level.INFO, "Request received: " + request);
        logger.log(Level.FINE, "Headers : \n" + requestHeaders);

        if (!httpVerb.equals("GET")) {
            logger.log(Level.WARNING, "request not supported from " + getAddress());
            reply(out, HttpHelper.notAllowed());
            return;
        }

        if (resource == null) {
            logger.log(Level.WARNING, "resource not specified from " + getAddress());
            reply(out, HttpHelper.badRequest());
            return;
        }

        String filePath = getPathForResource(resource);
        if (!HttpMedia.isSupported(filePath)) {
            logger.log(Level.WARNING, "request for content type not supported from " + getAddress());
            reply(out, HttpHelper.unsupportedMedia());
            return;
        }

        File file = new File(filePath);
        if (file.exists() && !file.isDirectory()) {
            reply(out, HttpHelper.ok());
        } else {
            logger.log(Level.WARNING, file.getPath() + " not found");
            reply(out, HttpHelper.notFound());
            filePath = WebServer.DOCUMENT_ROOT + "404.html";
            file = new File(filePath);
        }

        reply(out, HttpHelper.contentType(filePath));
        reply(out, HttpHelper.contentLength(file.length()));
        streamFile(out, file);
    }
    private String fetchRequestHeaders(BufferedReader in) throws IOException {
        String line;
        StringBuilder builder = new StringBuilder();
        while ((line = in.readLine()) != null && !line.isEmpty()) {
            builder.append(line).append("\n");
        }
        return builder.toString();
    }

    private String getPathForResource(String resource) {
        String filePath = resource;
        Pattern pattern = Pattern.compile("(\\.[^.]+)$");
        Matcher matcher = pattern.matcher(filePath);

        if (!matcher.find()) {
            filePath += "/index.html";
        }

        return WebServer.DOCUMENT_ROOT + filePath;
    }

    private void reply(DataOutputStream out, String response) throws IOException {
        out.writeBytes(response);
    }

    private void streamFile(DataOutputStream out, File file) throws IOException {
        try (FileInputStream in = new FileInputStream(file)) {
            byte[] buffer = new byte[1024];
            int numBytes;
            while ((numBytes = in.read(buffer)) != -1) {
                out.write(buffer, 0, numBytes);
            }
        }
    }

    private void close() {
        try {
            logger.log(Level.INFO, "closing client socket for " + getAddress());
            clientSocket.close();
        } catch (IOException e) {
            logger.log(Level.INFO, e.getMessage());
        }
    }

    private String getAddress() {
        return clientSocket.getInetAddress().getHostAddress() + ":" + clientSocket.getLocalPort();
    }
}

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.io.File;
import java.nio.file.Files;
import java.net.InetSocketAddress;

public class SimpleWebServer {

    public static void main(String[] args) throws IOException {
        // Cria o servidor na porta 8080
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        // Define o contexto para a raiz "/"
        server.createContext("/", new RootHandler());

        // Define o contexto para "/logo.png"
        server.createContext("/logo.png", new LogoHandler());

        // Define o contexto para lidar com 404 (rotas não encontradas)
        server.createContext("/404", new NotFoundHandler());

        // Inicia o servidor
        server.setExecutor(null); // Usa um executor default
        server.start();
        System.out.println("Servidor iniciado na porta 8080");
    }

    // Handler para a página raiz "/"
    static class RootHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String response = "root page";
            exchange.sendResponseHeaders(200, response.length());
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }

    // Handler para servir a imagem "logo.png"
    static class LogoHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            File file = new File("logo.png"); // Caminho do arquivo logo.png
            if (file.exists()) {
                exchange.getResponseHeaders().set("Content-Type", "image/png");
                byte[] bytes = Files.readAllBytes(file.toPath());
                exchange.sendResponseHeaders(200, bytes.length);
                OutputStream os = exchange.getResponseBody();
                os.write(bytes);
                os.close();
            } else {
                String response = "File not found";
                exchange.sendResponseHeaders(404, response.length());
                OutputStream os = exchange.getResponseBody();
                os.write(response.getBytes());
                os.close();
            }
        }
    }

    // Handler para 404 Not Found
    static class NotFoundHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String response = "<html><body><h1>404 - Page Not Found</h1></body></html>";
            exchange.sendResponseHeaders(404, response.length());
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }
}
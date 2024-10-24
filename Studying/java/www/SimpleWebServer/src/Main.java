import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class Main {
    public static void main(String[] args) throws IOException {
        // Cria o servidor que irá escutar na porta 8080
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        // Define o contexto "/" e o handler para lidar com requisições
        server.createContext("/", new MyHandler());

        // Inicia o servidor
        server.setExecutor(null);  // Usa o executor padrão
        server.start();

        System.out.println("Servidor iniciado na porta 8080...");
    }

    // Definimos o handler que responde a requisições HTTP
    static class MyHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange t) throws IOException {
            // Mensagem de resposta
            String response = "Olá! Este é o meu servidor Java!";
            t.sendResponseHeaders(200, response.length());

            // Envia a resposta ao cliente
            OutputStream os = t.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }
}

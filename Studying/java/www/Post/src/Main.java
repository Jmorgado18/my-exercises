import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {
    public static void main(String[] args) {
        try {
            // Definimos a URL do servidor
            URL url = new URL("https://api.example.com/resource");

            // Abrimos a conexão com o servidor
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Definimos o método HTTP como POST (para envio de dados)
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);  // Permite enviar dados

            // Definimos o tipo de conteúdo como JSON
            connection.setRequestProperty("Content-Type", "application/json; utf-8");

            // Criamos o corpo da requisição (em formato JSON)
            String jsonInputString = "{\"name\": \"John\", \"age\": 30}";

            // Enviamos os dados (escrevemos no output stream)
            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            // Checamos o código de resposta do servidor
            int responseCode = connection.getResponseCode();

            System.out.println("Código de resposta: " + responseCode);

            // Fechamos a conexão
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

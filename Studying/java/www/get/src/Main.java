import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {
    public static void main(String[] args) {
        try {
            // Definimos a URL que queremos acessar
            URL url = new URL("http://www.google.com");

            // Abrimos a conexão com a URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Definimos o método HTTP para GET (leitura de dados)
            connection.setRequestMethod("GET");

            // Checamos o código de resposta do servidor
            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) { // código 200
                // Se a resposta for OK, lemos os dados retornados
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder content = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }
                in.close();

                // Exibimos o conteúdo
                System.out.println("Resposta: " + content.toString());
            } else {
                System.out.println("Falha na requisição. Código de resposta: " + responseCode);
            }

            // Fechamos a conexão
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

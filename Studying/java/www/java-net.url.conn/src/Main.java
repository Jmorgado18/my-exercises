import java.net.URL;
import java.net.URLConnection;

public class Main {
    public static void main(String[] args) {
        try {
            // Criar uma URL para um recurso na web
            URL url = new URL("https://www.wikipedia.com");

            // Abrir a conexão com o recurso
            URLConnection connection = url.openConnection();

            // Conectar ao recurso
            connection.connect();

            // Obter informações sobre o recurso
            System.out.println("Tipo de Conteúdo: " + connection.getContentType());
            System.out.println("Tamanho do Conteúdo: " + connection.getContentLength());
            System.out.println("Última Modificação: " + connection.getLastModified());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

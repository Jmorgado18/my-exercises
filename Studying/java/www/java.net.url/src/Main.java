import java.net.URL;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            // Criar uma URL para um recurso na web
            URL url = new URL("https://www.google.com");

            // Abrir um Scanner para ler o conteúdo da URL
            Scanner scanner = new Scanner(url.openStream());

            // Ler e imprimir o conteúdo da URL
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }

            // Fechar o Scanner
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

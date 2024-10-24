import java.io.FileInputStream;
import java.io.IOException;

public class ExemploByteLeitura {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("ficheiro.bin")) {
            int byteLido;
            // Lê byte a byte até o final do ficheiro (-1 indica fim do ficheiro)
            while ((byteLido = fis.read()) != -1) {
                System.out.print((char) byteLido); // Converter para char para ver os dados
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

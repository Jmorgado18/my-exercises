import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ExemploCharacterLeitura {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("ficheiro.txt"))) {
            String linha;
            // Lê linha por linha até o final do ficheiro
            while ((linha = br.readLine()) != null) {
                System.out.println(linha);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

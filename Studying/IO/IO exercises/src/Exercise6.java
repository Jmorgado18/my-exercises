import java.io.FileReader;
import java.io.IOException;

public class Exercise6 {
    public static void main(String[] args) {
        /*
        6- Leitura de Caracteres de um Arquivo
        Crie um programa que leia o conteúdo de um arquivo .txt
        usando FileReader e exiba o texto no console, caractere a caractere.
         */
        String caminhoArquivo = "files/bohemianRhapsody.txt";

        try (FileReader leitor = new FileReader(caminhoArquivo)) {
            int caractereLido;
            while ((caractereLido = leitor.read()) != -1) {
                System.out.print((char) caractereLido);
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }

    }
}

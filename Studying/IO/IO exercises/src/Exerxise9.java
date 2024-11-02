import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Exerxise9 {
    public static void main(String[] args) {
        String caminhoArquivo = "files/bohemianRhapsody.txt";

        int contagemLinhas = 0;
        int contagemPalavras = 0;


        try (BufferedReader leitor = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            while ((linha = leitor.readLine()) != null) {
                contagemLinhas++;

                String[] palavras = linha.trim().split("\\s+");
                contagemPalavras += palavras.length;
            }

            System.out.println("Total de linhas: " + contagemLinhas);
            System.out.println("Total de palavras: " + contagemPalavras);
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}

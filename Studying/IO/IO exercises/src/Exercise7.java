import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Exercise7 {
    public static void main(String[] args) {
        /*7 - Escrita de Caracteres em um Arquivo
                Escreva um programa que peça uma frase ao utilizador e
                grave-a num arquivo .txt usando FileWriter.
         */

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite uma frase: ");
        String frase = scanner.nextLine();

        String caminhoArquivo = "files/exercise7.txt";


        try (FileWriter escritor = new FileWriter(caminhoArquivo)) {
            escritor.write(frase);

            System.out.println("A frase foi gravada com sucesso no arquivo.");
        } catch (IOException e) {
            System.err.println("Erro ao gravar no arquivo: " + e.getMessage());
        }

        scanner.close();

    }
}

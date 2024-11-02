import java.io.FileInputStream;
import java.io.IOException;

public class Exercise1 {
    public static void main(String[] args) {

        /*
        1- Leitura de Bytes de um Arquivo
        Escreva um programa que leia os bytes de um arquivo .txt e os exiba no console. Utilize FileInputStream.
         */
        String caminhoDoArquivo = "files/bohemianRhapsody.txt"; // substitua pelo caminho do seu arquivo

        try (FileInputStream fileInputStream = new FileInputStream(caminhoDoArquivo)) {
            int byteLido;
            int totalBytes = 0;

            while ((byteLido = fileInputStream.read()) != -1) {
                System.out.print(byteLido + "\n "); // Exibe o valor do byte lido
                totalBytes=totalBytes+byteLido;
                System.out.print((char) byteLido); // Exibe o caractere correspondente ao byte lido
                System.out.println("Total de bytes lidos " + totalBytes);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

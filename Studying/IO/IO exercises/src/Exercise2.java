import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {
        /*
        2 - Escrita de Bytes em um Arquivo
        Escreva um programa que receba uma string do usuário, converta-a em bytes e grave-a num arquivo .txt. Use FileOutputStream.
        */

        Scanner scanner = new Scanner(System.in);


        System.out.println("Digite uma palavra: ");
        String string = scanner.next();
        System.out.println("A palavra digitada foi: " + string);


        String caminhoArquivo = "files/exercise2.txt";

        try (FileOutputStream fileOutputStream = new FileOutputStream(caminhoArquivo)) {

            byte[] bytes = string.getBytes();
            fileOutputStream.write(bytes);


            System.out.println("A palavra \"" + string + "\" foi gravada com " + bytes.length + " bytes no arquivo \"" + caminhoArquivo + "\".");
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao gravar o arquivo: " + e.getMessage());
        }


        scanner.close();
    }
}

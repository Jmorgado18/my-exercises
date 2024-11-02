import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Exercise3 {
    public static void main(String[] args) {
        /*
        3-Copiar Conteúdo de um Arquivo Byte a Byte
        Crie um programa que copie o conteúdo de um arquivo para outro,
        lendo e escrevendo byte a byte. Use FileInputStream e FileOutputStream.
        */

        String caminhoOrigem = "files/bohemianRhapsody.txt";
        String caminhoDestino = "files/exercicio3.txt ";

        try (
                FileInputStream entrada = new FileInputStream(caminhoOrigem);
                FileOutputStream saida = new FileOutputStream(caminhoDestino)
        ) {
            int byteLido;
            while ((byteLido = entrada.read()) != -1) {
                saida.write(byteLido);
            }
            System.out.println("Arquivo copiado com sucesso!");
        } catch (IOException e) {
            System.err.println("Ocorreu um erro ao copiar o arquivo: " + e.getMessage());
        }
    }
}



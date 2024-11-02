import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Exercise5 {
    public static void main(String[] args) throws IOException {

        /*
        5 - Manipulação de Imagens com Bytes
        Escreva um programa que copie uma imagem (ex: .jpg) de uma pasta para outra.
        Use FileInputStream e FileOutputStream, e garanta que a imagem seja copiada corretamente.

         */

        String caminhoOrigem = "files/1.JPG";
        String caminhoDestino = "files/exercicio5.JPG ";


        FileInputStream entrada = new FileInputStream(caminhoOrigem);
        FileOutputStream saida = new FileOutputStream(caminhoDestino);

        int byteLido;
        while ((byteLido = entrada.read()) != -1) {
            saida.write(byteLido);
        }


    }
}

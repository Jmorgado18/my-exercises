import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ExemploCharacterEscrita {
    public static void main(String[] args) {
        String dados = "Este é um teste de escrita de caracteres!";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("ficheiro.txt"))) {
            bw.write(dados);  // Escreve a string no ficheiro
            bw.newLine();  // Adiciona uma nova linha
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

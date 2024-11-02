import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Exercise10 {
    /*
    10 - Cifrar Texto e Gravar num Arquivo
    Escreva um programa que leia um arquivo de texto, aplique uma cifra simples (ex: rot13, que desloca cada letra 13 posições), e grave o texto cifrado num novo arquivo.
    Ao ler novamente o arquivo cifrado, o programa deve decifrá-lo e exibir o texto original.
     */
    public static void main(String[] args) {

        String caminhoArquivoOriginal = "files/bohemianRhapsody.txt";

        String caminhoArquivoCifrado = "files/textoCifrado_exercise10.txt";

        cifrarTexto(caminhoArquivoOriginal, caminhoArquivoCifrado);


        decifrarTexto(caminhoArquivoCifrado);
    }

    // Método para cifrar o texto
    private static void cifrarTexto(String caminhoOrigem, String caminhoDestino) {
        try (BufferedReader leitor = new BufferedReader(new FileReader(caminhoOrigem));
             BufferedWriter escritor = new BufferedWriter(new FileWriter(caminhoDestino))) {

            String linha;
            while ((linha = leitor.readLine()) != null) {
                String linhaCifrada = rot13(linha); // Aplica ROT13 à linha
                escritor.write(linhaCifrada);
                escritor.newLine();
            }
            System.out.println("Texto cifrado gravado em: " + caminhoDestino);
        } catch (IOException e) {
            System.err.println("Erro ao cifrar o texto: " + e.getMessage());
        }
    }


    private static void decifrarTexto(String caminhoArquivo) {
        try (BufferedReader leitor = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            System.out.println("Texto decifrado:");
            while ((linha = leitor.readLine()) != null) {
                String linhaDecifrada = rot13(linha); // Aplica ROT13 à linha para decifrar
                System.out.println(linhaDecifrada);
            }
        } catch (IOException e) {
            System.err.println("Erro ao decifrar o texto: " + e.getMessage());
        }
    }

    // Método que aplica a cifra ROT13
    private static String rot13(String input) {
        StringBuilder resultado = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                c = (char) ((c - base + 13) % 26 + base); // Cifra ROT13
            }
            resultado.append(c); // Adiciona o caractere (cifrado ou não) ao resultado
        }
        return resultado.toString();
    }
}

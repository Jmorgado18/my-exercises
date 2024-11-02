import java.io.*;

public class Exercise8 {
    public static void main(String[] args) {
        /*
        8 - Leitura e Escrita de Caracteres com BufferedReader e BufferedWriter
        Escreva um programa que copie o conteúdo de um arquivo .txt para outro, linha por linha, usando BufferedReader e BufferedWriter para melhorar a eficiência.
         */


        String caminhoOrigem = "files/bohemianRhapsody.txt "; // Caminho do arquivo de origem
        String caminhoDestino = "files/Exercise8.txt"; // Caminho do arquivo de destino

        try (BufferedReader leitor = new BufferedReader(new FileReader(caminhoOrigem));
             BufferedWriter escritor = new BufferedWriter(new FileWriter(caminhoDestino))) {

            String linha;
            while ((linha = leitor.readLine()) != null) {
                escritor.write(linha); // Escreve a linha no arquivo de destino
                escritor.newLine(); // Adiciona uma nova linha no arquivo de destino
            }
            System.out.println("Arquivo copiado com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro ao copiar o arquivo: " + e.getMessage());
        }
    }
}
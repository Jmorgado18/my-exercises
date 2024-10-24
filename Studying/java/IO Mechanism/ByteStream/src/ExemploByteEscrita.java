import java.io.FileOutputStream;
import java.io.IOException;

public class ExemploByteEscrita {
    public static void main(String[] args) {
        String dados = "Este é um teste de escrita de bytes!";
        try (FileOutputStream fos = new FileOutputStream("ficheiro.bin")) {
            fos.write(dados.getBytes()); // Converter string para bytes e escrever no ficheiro
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

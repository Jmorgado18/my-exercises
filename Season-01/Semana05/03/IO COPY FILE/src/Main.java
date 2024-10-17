import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            FileUtils.copyFile("files/Original.docx", "files/Copy.DOCX");
            System.out.println("Tarefa realizada com sucesso");

        } catch (IOException e) {
            System.out.println("ERRO!");
            // throw new RuntimeException(e);
        }
    }
}

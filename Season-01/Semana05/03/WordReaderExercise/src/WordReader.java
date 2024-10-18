import java.io.*;
import java.util.Arrays;
import java.util.Iterator;
<<<<<<< HEAD

public class WordReader implements Iterable<String> {
    private final String filePath;
    private String[] words;

    public WordReader(String filePath) {
        this.filePath = filePath;
       // this.words = new String[0];
    }

    private void readFileByLine() throws IOException {
        BufferedReader bReader = new BufferedReader(new FileReader(filePath));
        StringBuilder resultBuilder = new StringBuilder();

        String line="";
        String result ="";
        while ((line = bReader.readLine()) != null) {
            resultBuilder.append(line).append("\n");
           // result += line +"\n";
        }

        bReader.close();
=======
import java.util.ArrayList;

public class WordReader implements Iterable<String> {
    FileReader fileReader;
    BufferedReader bReader;
    String[] words;


    public WordReader(String filePath) throws IOException, FileNotFoundException {
        try {
            this.fileReader = new FileReader(filePath);
            this.bReader = new BufferedReader(this.fileReader);
        } catch (FileNotFoundException ex){
            System.out.println("File not found!");
        }

        String line = "";
        String result = "";

        while((line = bReader.readLine()) != null){
            line = line.replaceAll("[^a-zA-Z ]", "");
            result += line;
        }

        this.bReader.close();

>>>>>>> f6d174a7dd516a00afac48ff6ecfd67c79eced17
        this.words = result.split(" ");
    }

    @Override
    public Iterator<String> iterator() {
<<<<<<< HEAD
        try {
            readFileByLine();
        } catch (IOException e) {
            throw new RuntimeException("Erro ao ler o arquivo: " + e.getMessage(), e);
        }
        
        return Arrays.stream(words).iterator();
    }

}
=======
        return Arrays.stream(this.words).iterator();
    }
}
>>>>>>> f6d174a7dd516a00afac48ff6ecfd67c79eced17

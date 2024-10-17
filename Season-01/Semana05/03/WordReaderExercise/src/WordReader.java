import java.io.*;
import java.util.Arrays;
import java.util.Iterator;

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
        this.words = result.split(" ");
    }

    @Override
    public Iterator<String> iterator() {
        try {
            readFileByLine();
        } catch (IOException e) {
            throw new RuntimeException("Erro ao ler o arquivo: " + e.getMessage(), e);
        }
        
        return Arrays.stream(words).iterator();
    }

}
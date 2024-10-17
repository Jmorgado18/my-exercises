import java.io.*;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class WordReader implements Iterable<String> {
    private final String filePath;
    private String[] result;

    public WordReader(String filePath) {
        this.filePath = filePath;
        this.result = new String[100];
    }

    private void readFileByLine() throws IOException {
        BufferedReader bReader = new BufferedReader(new FileReader(filePath));
        StringBuilder resultBuilder = new StringBuilder();

        String line;
        while ((line = bReader.readLine()) != null) {
            resultBuilder.append(line).append("\n");
        }

        bReader.close();
        this.result = resultBuilder.toString().split("\\s+");
    }

    @Override
    public Iterator<String> iterator() {
        try {
            readFileByLine();
        } catch (IOException e) {
            throw new RuntimeException("Erro ao ler o arquivo: " + e.getMessage(), e);
        }
        
        return Arrays.stream(result).iterator();
    }

}
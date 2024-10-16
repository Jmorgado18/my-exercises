import java.io.*;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
public class WordReader implements Iterable<String> {
    private final String filePath;
    private String[] result;

    public WordReader(String filePath) {
        this.filePath = filePath;
    }

    private String readFileByLine(String filePath) throws IOException {

        BufferedReader bReader = new BufferedReader(new FileReader(filePath));

        String line = "";
        String result = "";

        // using the buffered reader we can read lines
        while((line = bReader.readLine()) != null) {
            result += line + "\n";
        }

        bReader.close();
        this.result=result.split(" ");

        return result;
    }

    @Override
    public Iterator<String> iterator() {
        return Arrays.stream(result).iterator();
    }


    /*private String readFileByLine(String file) throws IOException {

        // create a new file reader
        FileReader bReader = new FileReader(file);

        // wrap the file reader using a buffered reader
        BufferedReader cReader = new BufferedReader(bReader);

        String line = "";
        String result = "";

        // using the buffered reader we can read lines
        while ((line = cReader.readLine()) != null) {
            result += line + "\n";
        }
        this.result = result.split(" ");

        bReader.close();

        return result;
    }



    @Override
    public Iterator<String> iterator() {
        return Arrays.stream(result).iterator();


    }*/
}


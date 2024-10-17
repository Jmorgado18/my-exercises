package io.codeforall.fanstatics;

    import java.io.*;
    import java.util.Arrays;
    import java.util.Iterator;
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

            this.words = result.split(" ");
        }

        @Override
        public Iterator<String> iterator() {
            return Arrays.stream(this.words).iterator();
        }
    }

package io.codeforall.fanstatics;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static final String FILE_PATH = "rsc/lorem.txt";
    public static void main(String[] args) throws IOException {

        try {
            WordReader wordReader = new WordReader(FILE_PATH);
            for( String word : wordReader){
                System.out.println(word);
            }
        } catch (IOException ex){
            System.out.println(ex.getMessage());
        }


    }
}

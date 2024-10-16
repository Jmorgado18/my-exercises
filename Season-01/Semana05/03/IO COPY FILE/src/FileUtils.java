import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileUtils {

    public static void copyFile(String input,String output) throws IOException {
        try(
        FileInputStream inputStream = new FileInputStream(input);
        FileOutputStream outputStream = new FileOutputStream(output))
        {
            byte[]buffer = new byte[1024];
            int byteReader;
            while ((byteReader = inputStream.read(buffer)) !=-1){
                 outputStream.write(buffer,0,byteReader);
            }
            inputStream.close();
            outputStream.close();
        }

    }
    }


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String message = "I'll send an SOS to the garbage world, " +
                "I hope that someone garbage gets my message in a garbage bottle.";

        /*
        Dividir a string em palavras
        Remover a palavra garbage
        coverter para maiusculas
        Juntas as palavras para uma unica string
         */

        String result = String.valueOf(Arrays.stream(message.split(" "))

                .filter(word -> !word.equals("garbage"))
                .unordered()
                .parallel()
                .map(String::toUpperCase)
                .reduce((acc, word) -> acc + " " + word));

        System.out.println(result);
    }
}
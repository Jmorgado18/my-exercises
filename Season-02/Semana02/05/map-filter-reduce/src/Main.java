import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String message = "I'll send an SOS to the garbage world, " +
                "I hope that someone garbage gets my message in a garbage bottle.";

        /*
        Dividir a string em palavras
        Remover a palavra garbage
        Converter para maiúsculas
        Juntar as palavras em uma única string
        */

        String result = Arrays.stream(message.split(" ")) // Dividir a string em palavras
                .filter(word -> !word.equalsIgnoreCase("garbage")) // Remover "garbage"
                .map(String::toUpperCase) // Converter para maiúsculas
                .reduce("", (acc, word) -> acc.isEmpty() ? word : acc + " " + word); // Juntar as palavras com espaço

        System.out.println(result);
    }
}

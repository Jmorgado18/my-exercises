import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String message = "I'll send an SOS to the garbage world, " +
                "I hope that someone garbage gets my message in a garbage bottle.";

        // Quebrar a mensagem em palavras e transformar conforme solicitado
        String result = Arrays.stream(message.split(" "))    // Divide a string em palavras
                .filter(word -> !word.equals("garbage"))     // Remove a palavra "garbage"
                .map(String::toUpperCase)                   // Converte para maiúsculas
                .reduce((acc, word) -> acc + " " + word)    // Junta as palavras em uma única string
                .orElse("");                                // Retorna string vazia se não houver palavras

        System.out.println(result);
    }
}
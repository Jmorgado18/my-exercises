import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Path path1 = Paths.get("files/file1.txt.txt");
        Path path2 = Paths.get("files/file2.txt.txt");

        try {
            List<String> lines = readFile(path1);
            System.out.println("Número total de palavras: " + countWords(lines));

            Scanner scanner = new Scanner(System.in);
            System.out.print("Digite o número mínimo de caracteres: ");
            int minLength = scanner.nextInt();

            System.out.println("Primeira palavra com mais de " + minLength + " caracteres: " +
                    findFirstWordWithMinLength(lines, minLength));

            System.out.println("Todas as palavras com mais de " + minLength + " caracteres: " +
                    findAllWordsWithMinLength(lines, minLength));

            System.out.println("A maior palavra é: " +
                    findLongestWord(lines));

            List<String> commonWords = findCommonWords(path1, path2);
            System.out.println("Palavras comuns nos dois ficheiros: " + commonWords);
        } catch (IOException e) {
            System.out.println("Erro ao ler o ficheiro: " + e.getMessage());
        }
    }

    public static List<String> readFile(Path path) throws IOException {
        return Files.readAllLines(path);
    }

    public static int countWords(List<String> lines) {
        return lines.stream()
                .flatMap(line -> List.of(line.split("\\W+")).stream())
                .filter(word -> !word.isEmpty())
                .map(String::toLowerCase)
                .collect(Collectors.toList())
                .size();
    }

    public static String findFirstWordWithMinLength(List<String> lines, int minLength) {
        return lines.stream()
                .flatMap(line -> List.of(line.split("\\W+")).stream())
                .filter(word -> word.length() > minLength)
                .map(String::toLowerCase)
                .findFirst()
                .orElse("Nenhuma palavra encontrada");
    }

    public static List<String> findAllWordsWithMinLength(List<String> lines, int minLength) {
        return lines.stream()
                .flatMap(line -> List.of(line.split("\\W+")).stream())
                .filter(word -> word.length() > minLength)
                .map(String::toLowerCase)
                .distinct()
                .collect(Collectors.toList());
    }

    public static String findLongestWord(List<String> lines) {
        return lines.stream()
                .flatMap(line -> List.of(line.split("\\W+")).stream())
                .filter(word -> !word.isEmpty())
                .map(String::toLowerCase)
                .reduce("", (a, b) -> a.length() >= b.length() ? a : b);
    }

    public static List<String> findCommonWords(Path path1, Path path2) throws IOException {
        List<String> wordsFile1 = readFile(path1);
        List<String> wordsFile2 = readFile(path2);

        List<String> uniqueWordsFile1 = wordsFile1.stream()
                .flatMap(line -> List.of(line.split("\\W+")).stream())
                .filter(word -> !word.isEmpty())
                .map(String::toLowerCase)
                .distinct()
                .collect(Collectors.toList());

        List<String> uniqueWordsFile2 = wordsFile2.stream()
                .flatMap(line -> List.of(line.split("\\W+")).stream())
                .filter(word -> !word.isEmpty())
                .map(String::toLowerCase)
                .distinct()
                .collect(Collectors.toList());

        uniqueWordsFile1.retainAll(uniqueWordsFile2);
        return uniqueWordsFile1;
    }
}

import java.util.Scanner;

public class GridGenerator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Digite a palavra que você quer que apareça no grid: ");
            String word = scanner.next().toUpperCase();

            Grid grid = new Grid(20, 20);
            grid.fillWithRandomLetters();
            Hint hint = grid.placeWord(word);

            grid.printGrid();

            System.out.println("\nEscreva '/help' para obter uma dica sobre onde está a palavra.");
            System.out.println("Escreva '/next' para gerar um novo grid com outra palavra.");
            String input;
            boolean searching = true;

            while (searching) {
                System.out.print("Procurando a palavra: ");
                input = scanner.next();

                if (input.equalsIgnoreCase("/help")) {
                    hint.provideHint();
                } else if (input.equalsIgnoreCase("/next")) {
                    searching = false;
                }
            }
        }
    }
}

import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Game game1 = new Game();
        Player player1 = new Player("João");

        NumberGenerator numberGenerator = new NumberGenerator();


        int gameRandomNumber = numberGenerator.getNrRandom(game1);
        System.out.println("O número aleatório do jogo foi gerado.");

        // O jogador tenta adivinhar o número
        int playerRandomNumber;
        do {
            // O jogador pede um número aleatório
            playerRandomNumber = player1.requestRandomNumber(numberGenerator);
            System.out.println(player1.getName() + " pediu o número: " + playerRandomNumber);

            // Compara os números
            if (playerRandomNumber != gameRandomNumber) {
                System.out.println("Os números não são iguais. Tente novamente.");
            }
        } while (playerRandomNumber != gameRandomNumber);

        System.out.println(player1.getName() + " acertou o número do jogo: " + gameRandomNumber);

    }
}

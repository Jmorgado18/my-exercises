import java.util.stream.Stream;
import java.util.List;
import java.util.ArrayList;

public class PerfectNumbers {

    // Método auxiliar para verificar se um número é perfeito
    public static boolean isPerfect(int number) {
        int sum = 0;

        // Encontrar os divisores de 'number' e somá-los
        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }

        return sum == number;
    }

    public static void main(String[] args) {
        // Defina o limite para a quantidade de números perfeitos que deseja encontrar
        int limit = 4; // Vamos buscar os primeiros 4 números perfeitos

        // Gerar uma stream infinita de números inteiros, começando de 1
        Stream<Integer> perfectNumbers = Stream.iterate(1, n -> n + 1)
                .filter(PerfectNumbers::isPerfect)
                .limit(limit);

        // Imprimir os números perfeitos
        perfectNumbers.forEach(System.out::println);
    }
}

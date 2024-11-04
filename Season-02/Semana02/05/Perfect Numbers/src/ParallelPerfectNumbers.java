import java.util.stream.Stream;

public class ParallelPerfectNumbers {
    public static boolean isPerfect(int number) {
        int sum = 0;
        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }
        return sum == number;
    }

    public static void main(String[] args) {
        int limit = 4;

        Stream<Integer> perfectNumbers = Stream.iterate(1, n -> n + 1)
                .parallel() // Torna a stream paralela
                .filter(ParallelPerfectNumbers::isPerfect)
                .limit(limit);

        perfectNumbers.forEach(System.out::println);
    }
}

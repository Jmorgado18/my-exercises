public class Main {

    public static final String STRING = "chama chama não chama";

    public static void main(String[] args) {
        UniqueWord wc = new UniqueWord(STRING);

        for (String word : wc) {
            System.out.println(word);
        }

    }
}

public class Main {
    public static final String STRING = "test word chama chama chama";

    public static void main(String[] args) {
      /*  WordHistogramComp wordhistogram = new WordHistogramComp(STRING);
        System.out.println("map has " + wordhistogram.size() + " distinct words");

        for (String word : wordhistogram) {
            System.out.println(word + " : " + wordhistogram.get(word));
        }*/
        WordHistogramInh wordhistogram1 = new WordHistogramInh(STRING);
        System.out.println("map has " + wordhistogram1.size() + " distinct words");

       // wordhistogram1.clear();
        for (String word : wordhistogram1) {
            System.out.println(word + " : " + wordhistogram1.get(word));
        }
    }
}

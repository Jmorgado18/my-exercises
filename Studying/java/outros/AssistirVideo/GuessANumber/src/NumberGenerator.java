public class NumberGenerator {
    private int nrRandom;


    public int getNrRandom(Player player) {
        nrRandom = (int) (Math.random() * 10);
        return nrRandom;
    }


    public int getNrRandom(Game game) {
        nrRandom = (int) (Math.random() * 10);
        return nrRandom;
    }


}

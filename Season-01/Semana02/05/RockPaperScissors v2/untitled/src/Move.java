public enum Move {
    ROCK,
    PAPER,
    SCISSORS;

    public static Move getMoves() {
        Move move = Move.values()[(int) ((Math.random())*3)];
        return move;
    }
}

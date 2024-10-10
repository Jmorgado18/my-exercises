package io.CodeForAll.Bootcamp;

import java.sql.SQLOutput;
public enum Move {
    ROCK,
    PAPER,
    SCISSORS;

    public static Move getMove() {

        Move move = Move.values()[(int) ((Math.random())*3)];
        return move;
    }
}




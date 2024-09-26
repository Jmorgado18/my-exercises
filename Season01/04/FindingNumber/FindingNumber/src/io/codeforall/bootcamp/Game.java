package io.codeforall.bootcamp;

public class Game {

    private int gameNumber;

    public int getGameNumber() {
      //  NumberGenarator numberGenarator = new NumberGenarator();
        gameNumber = NumberGenarator.getRandomNumber();
        return gameNumber;
    }



    }

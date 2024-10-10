package io.codeforall.bootcamp;

public class Player {
    String name;
    private int playerNumber;

    public int getPlayerNumber(){
        playerNumber = NumberGenarator.getRandomNumber();
        return playerNumber;
    }



}

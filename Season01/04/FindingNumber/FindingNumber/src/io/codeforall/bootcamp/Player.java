package io.codeforall.bootcamp;

public class Player {

    private int playerNumber;

    public int getPlayerNumber(){
        //NumberGenarator numberGenarator = new NumberGenarator();
        playerNumber = NumberGenarator.getRandomNumber();
        return playerNumber;
    }


}

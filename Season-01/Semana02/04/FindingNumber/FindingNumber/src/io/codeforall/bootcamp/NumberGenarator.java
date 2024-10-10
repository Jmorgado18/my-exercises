package io.codeforall.bootcamp;

public class NumberGenarator {
    public static int getRandomNumber() {
       int number = (int) (Math.round(Math.random() * 11));
       return number;
    }



}

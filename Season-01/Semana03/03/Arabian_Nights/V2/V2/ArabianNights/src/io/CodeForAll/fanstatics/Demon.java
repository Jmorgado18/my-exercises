package io.CodeForAll.fanstatics;

public class Demon extends Genie {


    boolean firstTime = true;

    String demonEmoji = "\uD83D\uDE08";
    String lampEmoji = "\uD83D\uDCA1";
    public Demon(int nrOfWishes) {
        super(nrOfWishes);

    }
    @Override
    public void doWish() {


        if (firstTime == true) {

            for (int i = 0; i < nrOfWishes; i++) {
                System.out.println("Your Wish has been granted by DEMON " + demonEmoji);
                firstTime = false; }


        } else {
            
            System.out.println("Your Wish has been granted by Demon Genie "+ demonEmoji);

        }
        int recharge = ((int) (Math.random() * 11));

        if (recharge > 7) {
            System.out.println("---------------------------");
            System.out.println("Your Lamp has been Recharged " + lampEmoji);
            System.out.println("---------------------------");
        } else {
            System.out.println("---------------------------");
            System.out.println("You failed to recharge " + lampEmoji);
            System.out.println("---------------------------");
               firstTime=false ; 
            doWish();

        }

    }
}






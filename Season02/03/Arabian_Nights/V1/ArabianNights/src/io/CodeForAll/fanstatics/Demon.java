package io.CodeForAll.fanstatics;

public class Demon extends Genie {
    private int nrOfWishes;
    private int kk = 1;
    boolean firstTime = true;

    public Demon(int nrOfWishes) {
        super();
        this.nrOfWishes = nrOfWishes;
    }

    public void doWish() {

        System.out.println(firstTime);
        if (firstTime = true) {

            for (int i = 0; i < nrOfWishes; i++) {
                System.out.println("Your Wish has been granted by Demon Genie " + i);
                firstTime = false; }


        } else if (firstTime=false){
            
            System.out.println("Your Wish has been granted by Demon Genie");
            firstTime = false;
        }
        int recharge = ((int) (Math.random() * 11));
        System.out.println(recharge);
        if (recharge > 7) {
            System.out.println("Your Lamp has been Recharged");
            System.out.println("==========================");
             return;
        } else {
               firstTime=false ; 
            doWish();

        }

    }
}






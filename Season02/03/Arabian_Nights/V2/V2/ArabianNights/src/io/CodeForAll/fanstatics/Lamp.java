package io.CodeForAll.fanstatics;

public class Lamp {
    private int rubs;

    private int countRubs;


    public Lamp(int Genies) {
        this.rubs = Genies;
    }

    public void rub() {
        countRubs++;
        if (countRubs <= rubs) {

            //System.out.println(rubs);
           // System.out.println(countRubs);
            if (countRubs % 2 == 0) {
                FriendlyGenie friendlyGenie1 = new FriendlyGenie(3);
                friendlyGenie1.doWish();


            } else {
                GrumpyGenie grumpyGenie = new GrumpyGenie(3);
                grumpyGenie.doWish();
            }

        } else {
            Demon demon = new Demon(3);
            demon.doWish();
        }
    }

}




package io.CodeForAll.fanstatics;

public class FriendlyGenie extends Genie{

    private int nrOfWishes;
    public FriendlyGenie(int nrOfWishes){
        super();

        this.nrOfWishes=nrOfWishes;
    }

    public void doWish() {

        for (int i = 0; i < nrOfWishes; i++) {
            System.out.println("Your Wish has been granted by Friendly Genie");


        }
        System.out.println("=============================================");
    }

}


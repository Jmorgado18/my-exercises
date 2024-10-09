package io.CodeForAll.fanstatics;

public class FriendlyGenie extends Genie{

    private int nrOfWishes;
    String genieEmoji = "\uD83E\uDDDE";
    public FriendlyGenie(int nrOfWishes){
        super(nrOfWishes);
        this.nrOfWishes=nrOfWishes;
    }
    @Override
    public void doWish() {

        for (int i = 0; i < nrOfWishes; i++) {
            System.out.println("Your Wish has been granted by Friendly Genie " + genieEmoji);


        }
        System.out.println("=============================================");
    }

}


package io.codeforall.bootcamp;

public class Playground {

    public static void main(String[] args) {
        int nrplayer;
        int nrgame;
        boolean flag=false;
        int count =1 ;
        Player player1 = new Player();
        nrplayer = player1.getPlayerNumber();

        System.out.println("O numero do player é " + nrplayer);

        Game game1 = new Game();
        nrgame = game1.getGameNumber();
        System.out.println("O numero do Game é " + nrgame);

        while(!flag) {

            if (nrplayer == nrgame) {

                System.out.println("Game over, o player acertou após " + count + " tentativas");
                flag = true;
            } else {
                //volta a procurar
                   count =count+1;
                nrplayer = player1.getPlayerNumber();
                System.out.println("O numero do player é " + nrplayer); 

            }
        }
    }
}
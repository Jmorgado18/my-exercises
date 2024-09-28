package io.codeforall.bootcamp;

public class Playground {

    public static void main(String[] args) {
        int nrplayer;
        int nrgame;
        boolean flag=false;
        int count =1 ;


        Player player1 = new Player();

        Game game1 = new Game();
        nrgame = game1.getGameNumber();
        System.out.println("O numero do Game é " + nrgame);

        while(!flag && count<=10) {
            nrplayer = player1.getPlayerNumber();
            System.out.println("O numero do player é " + nrplayer);
            if (count==9){
                System.out.println("Uma tentativa restante");
            }else if(count == 10){
                System.out.println("Acabaram as tentativas");

            }
            if (nrplayer == nrgame) {

                System.out.println("PARABÉNS, o player acertou após " + count + " tentativas");
                flag = true;
            } else {
                //volta a procurar
                count =count+1;

            }
        }
    }
}
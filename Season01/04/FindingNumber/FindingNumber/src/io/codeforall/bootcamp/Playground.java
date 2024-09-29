package io.codeforall.bootcamp;

public class  Playground {

    public static void main(String[] args) {
        int nrplayer;
        int nrgame;
        boolean flag = false;
        int count = 1;


        Player player1 = new Player();
        Player bot = new Player();
        player1.name = "João";
        bot.name = "Camila";
        Game game1 = new Game();
        nrgame = game1.getGameNumber();
        System.out.println("O numero de " + bot.name + " é " + nrgame);

        Player player2 = new Player();
        player2.name = "Bia";
        player2.getPlayerNumber();
        System.out.println("Jogadora: " + player2.name + ", Número do jogador: " + player2.getPlayerNumber());



       while(!flag && count<=10) {
            nrplayer = player1.getPlayerNumber();
            System.out.println("O numero de " + player1.name + " é " + nrplayer);
            if (count==9){
                System.out.println("Uma tentativa restante");
            }else if(count == 10){
                System.out.println("Acabaram as tentativas");

            }
            if (nrplayer == nrgame) {

                System.out.println("PARABÉNS, o " + player1.name + " acertou após " + count + " tentativas");
                flag = true;
            } else {
                //volta a procurar
                count =count+1;

            }
        }
    }

    }

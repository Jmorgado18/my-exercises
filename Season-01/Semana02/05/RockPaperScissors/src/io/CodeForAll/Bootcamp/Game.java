package io.CodeForAll.Bootcamp;

public class Game {
    Player player1 = new Player();
    Player player2 = new Player();

    int vitorias1;
    int vitorias2;
    public void winOrLose(){
        while(!( vitorias1 ==2 || vitorias2==2)){
            Move movePlayer2 = player2.getPlayerMove();
            Move movePlayer1 =player1.getPlayerMove();
            switch (movePlayer1){

                case ROCK :
                    if (movePlayer2 == Move.SCISSORS){
                        //Player 1 ganha
                        System.out.println("Player1 escolheu " + movePlayer1 + " Player2 escolheu " + movePlayer2 + ". PLAYER1 WINS");
                        vitorias1++;
                        System.out.println("O score é : Player1 wins :" +vitorias1 + ", Player2 wins " + vitorias2);
                    }else if (movePlayer2==Move.ROCK) {
                        //Empata
                        System.out.println("Player1 escolheu " + movePlayer1 + " Player2 escolheu " + movePlayer2 + ". EMPATE");
                    }else {
                        //Player 2 ganha
                        System.out.println("Player1 escolheu " + movePlayer1 + " Player2 escolheu " + movePlayer2 + ". PLAYER2 WINS");

                        vitorias2++;
                        System.out.println("O score é : Player1 wins :" +vitorias1 + ", Player2 wins " + vitorias2);
                    }
                    break;

                case PAPER:
                    if(movePlayer2 == Move.ROCK){
                        //Player1 ganha
                        System.out.println("Player1 escolheu " + movePlayer1 + " Player2 escolheu " + movePlayer2 + ". PLAYER1 WINS");
                        vitorias1++;
                        System.out.println("O score é : Player1 :" +vitorias1 + ", Player2 " + vitorias2);

                    }else if (movePlayer2== Move.PAPER) {
                        //empate
                        System.out.println("Player1 escolheu " + movePlayer1 + " Player2 escolheu " + movePlayer2 + ". EMPATE");
                    }else{
                        //Player 2 ganha
                        System.out.println("Player1 escolheu " + movePlayer1 + " Player2 escolheu " + movePlayer2 + ". PLAYER2 WINS");
                        vitorias2++;
                        System.out.println("O score é : Player1 :" +vitorias1 + ", Player2 " + vitorias2);

                    }
                    break;
                case SCISSORS:
                    if(movePlayer2==Move.PAPER){
                        //Player1 ganha
                        System.out.println("Player1 escolheu " + movePlayer1 + " Player2 escolheu " + movePlayer2 + ". PLAYER1 WINS");
                        vitorias1++;
                        System.out.println("O score é : Player1 :" +vitorias1 + ", Player2 " + vitorias2);

                    }else if (movePlayer2==Move.SCISSORS) {
                        //empate
                        System.out.println("Player1 escolheu " + movePlayer1 + " Player2 escolheu " + movePlayer2 + ". EMPATE");
                    }else{
                        //Player 2 ganha
                        System.out.println("Player1 escolheu " + movePlayer1 + " Player2 escolheu " + movePlayer2 + ". PLAYER2 WINS");
                        vitorias2++;
                        System.out.println("O score é : Player1 :" +vitorias1 + ", Player2 " + vitorias2);

                    }
                    break;

            }



        }
        if (vitorias1>vitorias2) {

            //Player 1 ganha
            System.out.println("Player 1 WINS com o socre " + vitorias1 + " vs " + vitorias2);

        } else if (vitorias2>vitorias1){
            //Player 2 ganha
            System.out.println("Player 2 WINS com o socre " + vitorias2 + " vs " + vitorias1 );
        } else {
            System.out.println("EMPATE");
        }
    }
}


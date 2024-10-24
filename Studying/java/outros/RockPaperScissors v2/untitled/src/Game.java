public class Game {
    Player player1 = new Player();
    Player player2 = new Player();
    int p1win;
    int p2win;
    public void WinOrLose(){
        while(p1win<2 && p2win<2){

            Move player1Move = Move.getMoves();
            Move player2Move = Move.getMoves();
            System.out.println("PLayer 1 Move : " + player1Move);
            System.out.println("Player 2 Move : " + player2Move);

            if (player1Move == player2Move){
                //EMPATE
                System.out.println("EMPATE");
            }
            switch (player1Move){
                case ROCK:
                    if (player2Move==Move.PAPER){
                        //Player 2 wins
                        p2win ++;
                        System.out.println("Player 2 wins ! ");
                    }else if (player2Move==Move.SCISSORS){
                        //Player 1 wins
                        System.out.println("Player 1 wins ! ");
                        p1win++;
                    }
                    break;
                case PAPER:
                    if (player2Move==Move.ROCK){
                        //Player 1 wins
                        System.out.println("Player 1 wins ! ");
                        p1win++;
                    }else if (player2Move==Move.SCISSORS){
                        //Player 2 wins
                        System.out.println("Player 2 wins ! ");
                        p2win++;
                    }
                    break;
                case SCISSORS:
                    if (player2Move==Move.PAPER){
                        //Player 1 wins
                        System.out.println("Player 1 wins ! ");
                        p1win++;
                    }else if (player2Move==Move.ROCK){
                        //Player 2 wins
                        System.out.println("Player 2 wins ! ");
                        p2win++;
                        break;
                    }

            }

            if (p1win>=2){
                System.out.println("PLAYER 1 WINS THE ROUND");
            }else if (p2win>=2){
                System.out.println("PLAYER 2 WINS THE ROUND");
            }
        }
    }
}

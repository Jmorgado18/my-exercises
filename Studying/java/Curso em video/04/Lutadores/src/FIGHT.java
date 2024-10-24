import java.util.Objects;
import java.util.Random;
public class FIGHT extends Fighter {
    private Fighter fighter1;
    private Fighter fighter2;
    private Fighter winner;
    private Fighter loser;

    public FIGHT(Fighter f1, Fighter f2) {
        super(f1.getName(), f1.getNationality(), f1.getAge(), f1.getHeight(), f1.getWeight(), f1.getNrwin(), f1.getNrloses(), f1.getNrdraws());
        this.fighter1 = f1;
        this.fighter2 = f2;
    }

    public void setFighters(Fighter f1, Fighter f2) {
        this.fighter1 = f1;
        this.fighter2 = f2;
    }

    public void fight() {
        if (fighter1 == null || fighter2 == null) {
            System.out.println("Fighters not set!");
            return;
        }

        if (!Objects.equals(fighter1.getCategory(), fighter2.getCategory())){
            System.out.println("Lutadores de categorias diferentes não podem lutar entre si! LUTA CANCELADA");
            return;
        }
        if(!Objects.equals(fighter1.getName(), fighter2.getName())){
            System.out.println("Um Lutador não pode lutar contra si mesmo! Burro do crllllll");
            return;

        }

        // Simular resultado do combate (apenas um exemplo aleatório)
        Random random = new Random();
        int result = random.nextInt(3); // 0: empate, 1: fighter1 vence, 2: fighter2 vence

        switch (result) {
            case 0: // Empate
                System.out.println("Fight between " + fighter1.getName() + " and " + fighter2.getName() + " ended in a draw.");
                fighter1.DrawFight();
                fighter2.DrawFight();
                break;
            case 1: // fighter1 vence
                System.out.println(fighter1.getName() + " wins against " + fighter2.getName());
                fighter1.winFight();
                fighter2.LoseFight();
                winner = fighter1;
                loser = fighter2;
                break;
            case 2: // fighter2 vence
                System.out.println(fighter2.getName() + " wins against " + fighter1.getName());
                fighter2.winFight();
                fighter1.LoseFight();
                winner = fighter2;
                loser = fighter1;
                break;
        }
    }

    public Fighter getWinner() {
        return winner;
    }

    public Fighter getLoser() {
        return loser;
    }
}
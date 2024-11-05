package io.CodeForAll.FanStatic;

import java.util.ArrayList;
import java.util.List;

public class Arena {
    private List<Hero> heroes;

    public Arena() {
        heroes = new ArrayList<>();
        heroes.add(new Mage());
        heroes.add(new Cleric());
        heroes.add(new Warrior());
        heroes.add(new Rogue());
    }

    public void startBattle() {

        TurnManager turnManager = new TurnManager(heroes);
        turnManager.displayStatus();
        while (!turnManager.checkVictory()) {
            turnManager.startTurn();
        }

        Hero winner = turnManager.getWinner();
        System.out.println("The winner is: " + winner.name);
    }
}

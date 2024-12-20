package io.CodeForAll.FanStatic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class TurnManager {
    private List<Hero> heroes;
    private Random random;

    public TurnManager(List<Hero> heroes) {
        this.heroes = heroes;
        this.random = new Random();
    }

    //Problema de lógica no uso do Shield. Warrior usa o shield quando ataca e não quando é atacado

    // Objetivo é , caso tenha o Shield ativo, nao recebe damage no próximo ataque que lhe façam

    public void startTurn() {
        Collections.shuffle(heroes);

        for (Hero attacker : heroes) {
            if (attacker.hp <= 0) continue;

            Hero target = selectRandomTarget(attacker);
            if (target.hp <= 0) continue;
            System.out.println("target:" + target.name);
            System.out.println("Atacker: " + attacker.name);
            if (target.isShield) {

                System.out.println("Warrior has a Shield. Do not take Damage!");
                System.out.println("------------------------\n");
                break;
            }
            performAbility(attacker, target);
            performAttack(attacker, target);
            displayStatus();
        }
    }


    private void performAbility(Hero attacker, Hero target) {
        if (attacker.mana >= attacker.ability.getManaCost() && attacker.ability.isAvailable()) {
            System.out.println(attacker.name + " uses ability on " + target.name + "!");
            attacker.useAbility(target);

        }
    }

    private void performAttack(Hero attacker, Hero target) {
        System.out.println(attacker.name + " attacks " + target.name);
        attacker.attack(target);
        attacker.ability.reduceCooldown();
    }

    private Hero selectRandomTarget(Hero attacker) {
        List<Hero> possibleTargets = new ArrayList<>(heroes);
        possibleTargets.remove(attacker);
        return possibleTargets.get(random.nextInt(possibleTargets.size()));
    }

    public void displayStatus() {
        System.out.println("\n--- Status of Heroes ---");
        for (Hero hero : heroes) {
            System.out.println(hero.name + " - HP: " + hero.hp + ", Mana: " + hero.mana);
        }
        System.out.println("------------------------\n");
    }

    public boolean checkVictory() {
        int aliveHeroes = (int) heroes.stream().filter(hero -> hero.hp > 0).count();
        return aliveHeroes <= 1;
    }

    public Hero getWinner() {
        return heroes.stream().filter(hero -> hero.hp > 0).findFirst().orElse(null);
    }
}

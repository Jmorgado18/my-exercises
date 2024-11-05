package io.CodeForAll.FanStatic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;


// Herois mortos continuam a ser atacados e a atacar !
// Herois com mana suficiente e que nao estão em cooldown não estão a usar a ability .
// Logica do metodo StartTurn a revisar
public class TurnManager {
    private List<Hero> heroes;
    private Random random;

    public TurnManager(List<Hero> heroes) {
        this.heroes = heroes;
        this.random = new Random();
    }

    public void startTurn() {
        // Embaralha a lista de heróis para definir uma ordem de turno aleatória
        Collections.shuffle(heroes);

        // Cada herói realiza uma ação no seu turno
        for (Hero attacker : heroes) {


            if(attacker.hp<=0) continue;
            Hero target = selectRandomTarget(attacker);
            if(target.hp<=0)continue;

            if((attacker.mana>=attacker.ability.getManaCost()) && attacker.ability.isAvailable()){
                System.out.println(attacker.name + " uses ability on " + target.name + "!");
                attacker.useAbility(target);
                attacker.mana-=attacker.ability.getManaCost();
                attacker.ability.reduceCooldown();

            }
            System.out.println(attacker.name + " atacks " + target.name);
            attacker.attack(target);
            displayStatus();

/*
            if ((attacker.hp <= 0 )&& (target.hp<0)) continue;  // Ignora heróis que foram derrotados



            // Usar habilidade se a mana for suficiente e a habilidade estiver disponível
            if ((attacker.mana >= attacker.ability.getManaCost()) && (attacker.ability.isAvailable())) {
                System.out.println(attacker.name + " uses ability on " + target.name + "!");
                attacker.useAbility(target);

                // Reduz o cooldown da habilidade após o turno
                attacker.ability.reduceCooldown();
            }

            System.out.println(attacker.name + " attacks " + target.name + "!");
            attacker.attack(target);



 */
        }
    }

    private Hero selectRandomTarget(Hero attacker) {
        List<Hero> possibleTargets = new ArrayList<>(heroes);
        possibleTargets.remove(attacker);  // Evita que o herói ataque a si mesmo
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
        return aliveHeroes <= 1;  // Condição de vitória: apenas um herói restante
    }

    public Hero getWinner() {
        return heroes.stream().filter(hero -> hero.hp > 0).findFirst().orElse(null);
    }
}
package io.CodeForAll.FanStatic;

public class Fireball extends AbstractAbility {
    private int attackBoost;

    public Fireball(int manaCost, int cooldown, int attackBoost) {
        super(manaCost, cooldown);
        this.attackBoost = attackBoost;
    }

    @Override
    public void apply(Hero user, Hero target) {
        user.attackPower += attackBoost;
        currentCooldown = cooldown;
        System.out.println(user.name + " increases attack power by " + attackBoost + "!");
    }
}

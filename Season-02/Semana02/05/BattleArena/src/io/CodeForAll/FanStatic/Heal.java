package io.CodeForAll.FanStatic;

public class Heal extends AbstractAbility {
    private int healAmount;

    public Heal(int manaCost, int cooldown, int healAmount) {
        super(manaCost, cooldown);
        this.healAmount = healAmount;
    }

    @Override
    public void apply(Hero user, Hero target) {
        user.hp += healAmount;  // Cura-se a si proprio
        currentCooldown = cooldown;  // Define cooldown após o uso
        System.out.println(user.name + " heals himself for " + healAmount + " HP.");
    }
}

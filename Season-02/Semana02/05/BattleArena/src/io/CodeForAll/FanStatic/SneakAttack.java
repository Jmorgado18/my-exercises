package io.CodeForAll.FanStatic;

public class SneakAttack extends AbstractAbility {
    private int sneakDamage;

    public SneakAttack(int manaCost, int cooldown, int sneakDamage) {
        super(manaCost, cooldown);
        this.sneakDamage = sneakDamage;
    }

    @Override
    public void apply(Hero user, Hero target) {
        target.hp -= sneakDamage;  // Causa dano ao alvo
        currentCooldown = cooldown;  // Define cooldown após o uso
        System.out.println(user.name + " deals " + sneakDamage + " sneak damage to " + target.name + "!");
    }
}

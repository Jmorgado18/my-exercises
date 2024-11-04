package io.CodeForAll.FanStatic;

public class ShieldBlock extends AbstractAbility {
    public ShieldBlock(int manaCost, int cooldown) {
        super(manaCost, cooldown);
    }

    @Override
    public void apply(Hero user, Hero target) {
        // Lógica para bloquear ataque (pode ser uma implementação específica)
        currentCooldown = cooldown;  // Define cooldown após o uso
        System.out.println(user.name + " prepares to block the next attack!");
    }
}

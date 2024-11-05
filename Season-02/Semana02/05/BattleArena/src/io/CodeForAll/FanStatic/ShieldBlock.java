package io.CodeForAll.FanStatic;

public class ShieldBlock extends AbstractAbility {
    public ShieldBlock(int manaCost, int cooldown) {
        super(manaCost, cooldown);
    }

    @Override
    public void apply(Hero user, Hero target) {

        currentCooldown = cooldown;
        user.isShield=true;
        System.out.println(user.name + " prepares to block the next attack!");
    }
}

package io.CodeForAll.FanStatic;

public abstract class AbstractAbility implements Ability {
    protected int manaCost;
    protected int cooldown;
    protected int currentCooldown = 0;

    public AbstractAbility(int manaCost, int cooldown) {
        this.manaCost = manaCost;
        this.cooldown = cooldown;
    }

    @Override
    public int getManaCost() {
        return manaCost;
    }

    @Override
    public boolean isAvailable() {
        return currentCooldown == 0;
    }

    @Override
    public void reduceCooldown() {
        if (currentCooldown > 0) {
            currentCooldown--;
        }
    }
}

package io.CodeForAll.FanStatic;

public interface Ability {
    void apply(Hero user, Hero target);
    int getManaCost();
    boolean isAvailable();
    void reduceCooldown();
}

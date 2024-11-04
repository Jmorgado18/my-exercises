package io.CodeForAll.FanStatic;

public class Rogue extends Hero {
    public Rogue() {
        super("Rogue", 100, 15, 4, new SneakAttack(10, 2, 30));
    }
}

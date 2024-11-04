package io.CodeForAll.FanStatic;

public class Cleric extends Hero {
    public Cleric() {
        super("Cleric", 100, 10, 5, new Heal(10, 3, 20));
    }
}

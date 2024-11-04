package io.CodeForAll.FanStatic;

public class Hero {
    private String name;
    private int HP;
    private int AtackForce;
    private int DefenseForce;
    private int mana;

    public Hero(String name, String HP, int atackForce, int defenseForce, int mana) {
        this.name = name;
        this.HP = 100;
        AtackForce = atackForce;
        DefenseForce = defenseForce;
        this.mana = mana;
    }
}

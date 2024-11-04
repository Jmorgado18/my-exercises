package io.CodeForAll.FanStatic;

public abstract class Hero {
    protected String name;
    protected int hp;
    protected int attackPower;
    protected int defensePower;
    protected int mana;
    protected Ability ability;  // A habilidade do herói

    public Hero(String name, int hp, int attackPower, int defensePower, Ability ability) {
        this.name = name;
        this.hp = hp;
        this.attackPower = attackPower;
        this.defensePower = defensePower;
        this.mana = 0;  // Mana inicial a zero
        this.ability = ability;
    }

    public void attack(Hero target) {
        // Lógica de ataque básico
        int damage = Math.max(0, this.attackPower - target.defensePower);
        target.hp -= damage;
        System.out.println(name + " deals " + damage + " damage to " + target.name);

        // Incrementa a mana após um ataque bem-sucedido
        this.mana += 10;
    }

    public void useAbility(Hero target) {
        if (this.mana >= ability.getManaCost() && ability.isAvailable()) {
            ability.apply(this, target);
            this.mana -= ability.getManaCost();
            System.out.println(name + " uses " + ability.getClass().getSimpleName() + " on " + target.name);
        } else {
            System.out.println(name + " doesn't have enough mana or ability is on cooldown.");
        }
    }
}

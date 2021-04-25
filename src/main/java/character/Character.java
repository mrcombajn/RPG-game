package main.java.character;

public abstract class Character {
    protected int strength;
    protected int hp;
    protected int mana;
    protected int stamina;
    protected int name;
    protected int x;
    protected int y;

    public Character(int strength, int hp, int mana, int stamina, int name, int x, int y) {
        this.strength = strength;
        this.hp = hp;
        this.mana = mana;
        this.stamina = stamina;
        this.name = name;
        this.x = x;
        this.y = y;
    }
}

package main.java.character;

public abstract class Character {
    protected int strength;
    protected int hp;
    protected int mana;
    protected int stamina;
    protected String name;
    protected int x;
    protected int y;

    public Character(int strength, int hp, int mana, int stamina, String name, int x, int y) {
        this.strength = strength;
        this.hp = hp;
        this.mana = mana;
        this.stamina = stamina;
        this.name = name;
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}

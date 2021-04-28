package main.java.character;


public class Gamer extends Character {

    public Gamer(int strength, int hp, int mana, int stamina, String name, int x, int y) {
        super(strength, hp, mana, stamina, name, x, y);
    }

    public void move(int toX, int toY) {
        if((x+toX>=0 && x+toX <=39) && (y+toY>=0 && y+toY <=39)) {
            x += toX;
            y += toY;
        }
    }
}

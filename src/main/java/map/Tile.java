package main.java.map;

public class Tile {
    private int x;
    private int y;
    private final String filePath;
    private final boolean enterable;
    private boolean isGamer = false;

    public void setGamer(boolean gamer) {
        isGamer = gamer;
    }

    public boolean isGamer() {
        return isGamer;
    }

    public Tile(int x, int y, String filePath, boolean enterable) {
        this.x = x;
        this.y = y;
        this.filePath = filePath;
        this.enterable = enterable;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getFilePath() {
        return filePath;
    }

    public boolean isEnterable() {
        return enterable;
    }
}

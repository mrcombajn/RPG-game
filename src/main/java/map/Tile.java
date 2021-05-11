package main.java.map;

public class Tile {
    private final int x;
    private final int y;
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

    public String getFilePath() {
        return filePath;
    }

    public boolean isEnterable() {
        return enterable;
    }
}

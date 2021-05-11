package main.java.engine;

public class CollisionController {
    private int mainQuestX;
    private int mainQuestY;

    public CollisionController(int mainQuestX, int mainQuestY) {
        this.mainQuestX = mainQuestX;
        this.mainQuestY = mainQuestY;
    }

    public void checkCollision(int playerX, int playerY) {
        if(mainQuestY == playerY && mainQuestX == playerX) {
            System.out.println("Wygrana!");
            mainQuestX = -1;
            mainQuestY = -1;
        }
    }
}

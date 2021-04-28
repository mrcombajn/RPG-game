package main.java.map;

import main.java.character.Gamer;
import main.java.engine.Main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Map {

    private static Map instance;
    private Tile[][] generatedMap;
    private Gamer gamer = Main.getGamer();

    static {
        try {
            instance = new Map();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private final int[][] map = new int[40][40];

    private Map() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src\\main\\resources\\map.txt"));
        for(int i = 0; i < 40; i++) {
            String [] line = reader.readLine().split("\\.");
            for(int j = 0; j < line.length; j++) {
                map[i][j] = Integer.parseInt(line[j]);
            }
        }
        reader.close();
        generateMap();
    }

    private void generateMap(){
        generatedMap = new Tile[40][40];
        for(int i = 0; i < 40; i++) {
            for (int j = 0; j < 40; j++) {
                switch (map[i][j]) {
                    case 1:
                        generatedMap[i][j] = new Tile(i, j, "src/main/resources/textures/trawa.png", true);
                        break;
                    case 2:
                        generatedMap[i][j] = new Tile(i, j, "src/main/resources/textures/skaly.png", false);
                        break;
                    case 3:
                        generatedMap[i][j] = new Tile(i, j, "src/main/resources/textures/woda.png", false);
                        break;
                    case 4:
                        generatedMap[i][j] = new Tile(i, j, "src/main/resources/textures/drzewo.png", false);
                        break;
                    case 5:
                        generatedMap[i][j] = new Tile(i, j, "src/main/resources/textures/mur.png", false);
                        break;
                    case 6:
                        generatedMap[i][j] = new Tile(i, j, "src/main/resources/textures/sciezka.png", true);
                        break;
                    case 7:
                        generatedMap[i][j] = new Tile(i, j, "src/main/resources/textures/dom.png", false);
                        break;
                }
            }
        }

    }

    public static Map getInstance() {
        return instance;
    }

    public ArrayList<Tile> getMapFromGamerCoordinates() {
        ArrayList<Tile> list = new ArrayList<>();

        int gamerX = gamer.getX();
        int gamerY = gamer.getY();

        int leftX, rightX;
        int topY, bottomY;

        if(gamerX <= 4) {
            leftX = 0;
            rightX = 9;
        }
        else if(gamerX >= 35) {
            rightX = 39;
            leftX = 30;
        }
        else {
            rightX = gamerX + 5;
            leftX = gamerX - 4;
        }

        if(gamerY <= 4) {
            topY = 0;
            bottomY = 9;
        }
        else if(gamerY >= 35) {
            bottomY = 39;
            topY = 30;
        }
        else {
            bottomY = gamerY + 5;
            topY = gamerY - 4;
        }

        for(int i = topY; i <= bottomY; i++) {
            for(int j = leftX; j <= rightX; j++) {
                list.add(generatedMap[i][j]);
                if(i == gamerY && j == gamerX) list.get(list.size()-1).setGamer(true);
                else list.get(list.size()-1).setGamer(false);
            }
        }

        System.out.println(gamerX + " " + gamerY);
        return list;
    }

    public boolean moveGamer(int toX, int toY) {
        int gamerNewX = gamer.getX() + toX;
        int gamerNewY = gamer.getY() + toY;

        if((gamerNewX < 0 || gamerNewX > 39) || (gamerNewY < 0 || gamerNewY > 39)) return false;
        if(!generatedMap[gamerNewY][gamerNewX].isEnterable()) return false;

        gamer.setX(gamerNewX);
        gamer.setY(gamerNewY);
        return true;
    }
}

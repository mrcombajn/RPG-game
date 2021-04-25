package main.java.map;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Map {

    private static Map instance;
    private Tile[][] generatedMap;

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
                        generatedMap[i][j] = new Tile(i, j, "../../resources/textures/trawa.png", true);
                        break;
                    case 2:
                        generatedMap[i][j] = new Tile(i, j, "../../resources/textures/skaly.png", false);
                        break;
                    case 3:
                        generatedMap[i][j] = new Tile(i, j, "../../resources/textures/woda.png", false);
                        break;
                    case 4:
                        generatedMap[i][j] = new Tile(i, j, "../../resources/textures/drzewo.png", false);
                        break;
                    case 5:
                        generatedMap[i][j] = new Tile(i, j, "../../resources/textures/mur.png", false);
                        break;
                    case 6:
                        generatedMap[i][j] = new Tile(i, j, "../../resources/textures/sciezka.png", false);
                        break;
                    case 7:
                        generatedMap[i][j] = new Tile(i, j, "../../resources/textures/dom.png", false);
                        break;
                }
            }
        }

    }

    public static Map getInstance() {
        return instance;
    }

}

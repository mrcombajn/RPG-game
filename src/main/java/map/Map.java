package main.java.map;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Map {

    private static Map instance;

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
    }

    public static Map getInstance() {
        return instance;
    }

    public int[][] getMap() {
        return map;
    }
}

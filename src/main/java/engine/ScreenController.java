package main.java.engine;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import main.java.map.Map;
import main.java.map.Tile;

import java.io.File;
import java.util.ArrayList;

public class ScreenController extends Thread {
    private final ObservableList<Node> images;
    private final Map mapInstance;

    @Override
    public void run() {
        updateGameScreenMap(mapInstance.getMapFromGamerCoordinates());
    }

    public ScreenController(ObservableList<Node> images, Map mapInstance) {
        this.images = images;
        this.mapInstance = mapInstance;
    }

    public void updateGameScreenMap(ArrayList<Tile> map) {


        for(int i = 0; i < map.size(); i++){
            if(images.get(i) instanceof ImageView) {
                File file;
                if(map.get(i).isGamer()) {
                    file = new File("src/main/resources/textures/hero.png");
                }
                else file = new File(map.get(i).getFilePath());
                Image img = new Image(file.toURI().toString(),true);
                ((ImageView) images.get(i)).setImage(img);
            }
        }
    }
}

package main.java.engine;

import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import main.java.map.Map;
import main.java.map.Tile;

import java.io.File;
import java.util.ArrayList;

public class GridPaneController extends Thread{
    @FXML
    GridPane gridPane;

    private ObservableList<Node> images;
    private Map mapInstance = Map.getInstance();

    public GridPaneController() {
        this.start();
        Main.getStage().addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                //   System.out.println(keyEvent.getCode());
                //   System.out.println(keyEvent.getCode().toString().equals("RIGHT"));

            }
        });
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            getChildren();
            updateGameScreenMap(mapInstance.getMapFromGamerCoordinates());
        } catch(Exception e) {

        }
    }

    private void getChildren() {

            int liczba = 0;
            images = gridPane.getChildren();
       /*     for (Node node : images) {
                // System.out.println(node);
                if(node instanceof ImageView) {
                  //  ((ImageView) node).setImage(new Image("@../../resources/textures/drzewo.png"));
                    File file = new File("src/main/resources/textures/mur.png");
                    Image img = new Image(file.toURI().toString(),true);
                    ((ImageView) node).setImage(img);
                   // System.out.println(((ImageView) node).getImage().getUrl());
                    liczba++;
                    //System.out.println(((ImageView) node).getId() + " " + ((ImageView) node).getImage());
                }
            }
            System.out.println(liczba);*/
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
        for(Tile tile : mapInstance.getMapFromGamerCoordinates()) {
            System.out.println(tile.getFilePath());
        }
    }

}

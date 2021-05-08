package main.java.engine;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import main.java.map.Map;

public class GridPaneController extends Thread{
    @FXML
    GridPane gridPane;

    private ObservableList<Node> images;
    private final Map mapInstance = Map.getInstance();

    public GridPaneController() {
        this.start();
        Main.getStage().addEventHandler(KeyEvent.KEY_PRESSED, keyEvent -> {
            switch(keyEvent.getCode().toString()) {
                case "UP":
                    if(mapInstance.moveGamer(0,-1)) createNewScreenController();
                    break;
                case "DOWN":
                    if(mapInstance.moveGamer(0,1)) createNewScreenController();
                    break;
                case "LEFT":
                    if(mapInstance.moveGamer(-1,0)) createNewScreenController();
                    break;
                case "RIGHT":
                    if(mapInstance.moveGamer(1,0)) createNewScreenController();
                    break;
                default:
                    break;
            }
        });
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            getChildren();
            createNewScreenController();
        } catch(Exception e) {
            System.out.println("Otyły panie, nie działa metoda run klasy GridPaneController");
        }
    }

    private void getChildren() {
        images = gridPane.getChildren();
    }

    private void createNewScreenController() {
        Thread th = new ScreenController(images, mapInstance);
        try {
            th.start();
            th.join();
        } catch (InterruptedException e) {
            System.out.println("Otyły panie, nie działa metoda createNewScreenController");
        }
    }



}

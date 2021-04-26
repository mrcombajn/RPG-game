package main.java.engine;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.io.File;

public class GridPaneController extends Thread{
    @FXML
    GridPane gridPane;

    private ObservableList<Node> images;

    public GridPaneController() {
        this.start();
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            getChildren();
        } catch(Exception e) {

        }
    }

    private void getChildren() {

            int liczba = 0;
            images = gridPane.getChildren();
            for (Node node : images) {
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
            System.out.println(liczba);

    }


}

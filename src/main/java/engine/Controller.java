package main.java.engine;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class Controller {
    @FXML
    GridPane gridPane;

    @FXML
    Button myButton;

    public void onClick() {
        try {
            int liczba = 0;

            ObservableList<Node> images = gridPane.getChildren();
            for (Node node : images) {
                System.out.println(node);
                if(node instanceof ImageView) {
                    liczba++;
                }
            }
            System.out.println(liczba);

        } catch(Exception e) {
            System.out.println("Otyły panie, nie działa");
        }
    }


}

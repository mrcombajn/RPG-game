package main.java.engine;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.java.character.Gamer;

import java.io.IOException;

public class Main extends Application {
    static Stage stage;
    private static Gamer gamer = new Gamer(10,100, 100,100, "Boris", 4, 35);

    @Override
    public void start(Stage primaryStage) throws Exception{
        stage = primaryStage;

        Parent root = FXMLLoader.load(getClass().getResource("GameScreen.fxml"));
        primaryStage.setTitle("Magnaci i Czarodzieje - The Game");
        primaryStage.setScene(new Scene(root,600,700));
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);

    }

    public static Stage getStage() {
        return stage;
    }

    public static Gamer getGamer() {
        return gamer;
    }
}

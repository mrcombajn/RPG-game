package main.java.engine;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    static Stage stage;
    @Override
    public void start(Stage primaryStage) throws Exception{
        stage = primaryStage;

        Parent root = FXMLLoader.load(getClass().getResource("GameScreen.fxml"));
        primaryStage.setTitle("Magnaci i Czarodzieje - The Game");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
        //changeScene();
    }


    public static void main(String[] args) {
        launch(args);
    }

    public void changeScene() throws IOException {
        Parent root = FXMLLoader.load(this.getClass().getResource("Test.fxml"));
        stage.setScene(new Scene(root, 1366, 720));
    }

}

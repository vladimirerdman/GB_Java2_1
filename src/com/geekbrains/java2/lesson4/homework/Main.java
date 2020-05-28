package com.geekbrains.java2.lesson4.homework;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Chat v0.1");
        Scene scene = new Scene(root, 650, 500);
        // From local file
        scene.getStylesheets().add(getClass().getResource("css/styles.css").toExternalForm());

        // Limit resizing
        /*
        primaryStage.heightProperty().addListener(e ->{
            if (primaryStage.getWidth() <= 650.0) {
                primaryStage.setMinWidth(650.0);
            }
        });
        primaryStage.heightProperty().addListener(e ->{
            if (primaryStage.getHeight() <= 522.0) {
                primaryStage.setMinHeight(522.0);
            }
        });
        */
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

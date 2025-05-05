package org.example.morsecodetree;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.stage.Stage;

public class TreeCanva extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Visualizador de Árvore Binária");
        MorseTree bst = new MorseTree();
        int height = bst.getHeight();
        int canvasHeight = 100 + height * 100;
        int canvasWidth = (int) Math.pow(2, height) * 40;
        Canvas canvas = new Canvas(canvasWidth, canvasHeight);
        bst.drawTree(canvas);
        Group root = new Group();
        root.getChildren().add(canvas);
        Scene scene = new Scene(root, canvasWidth, canvasHeight);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
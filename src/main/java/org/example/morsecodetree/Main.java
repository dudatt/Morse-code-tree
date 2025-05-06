package org.example.morsecodetree;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.stage.Stage;

import java.util.Scanner;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        //Print da arvore
        primaryStage.setTitle("Visualizador de Árvore Binária");
        MorseTree tree = new MorseTree();
        int height = tree.getHeight();
        int canvasHeight = 100 + height * 100;
        int canvasWidth = (int) Math.pow(2, height) * 40;
        Canvas canvas = new Canvas(canvasWidth, canvasHeight);
        tree.drawTree(canvas);
        Group root = new Group();
        root.getChildren().add(canvas);
        Scene scene = new Scene(root, canvasWidth, canvasHeight);
        primaryStage.setScene(scene);
        primaryStage.show();

        //Menu no console
        Scanner scanner = new Scanner(System.in);
        int opcaoMenu;
        do {
            System.out.println("O que deseja fazer?");
            System.out.println("1. Decodificar");
            System.out.println("2. Sair");
            opcaoMenu = scanner.nextInt();
            scanner.nextLine();
            String input;

            switch (opcaoMenu) {
                case 1:
                    System.out.println("Digite o que deseja decodificar: ");
                    input = scanner.nextLine();
                    System.out.println(tree.decode(input));
                    break;
                case 2:
                    System.out.println("Encerrando o programa...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Insira uma opção valida");
            }
        } while (opcaoMenu != 2);

    }
    public static void main(String[] args) {
        launch(args);
    }
}
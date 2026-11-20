package eu.epfc.labo12.microwave;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Microwave extends Application {

    private static String buttonName(int i) {
        return switch (i) {
            case 10 -> "0";
            case 11 -> "Start";
            case 12 -> "Stop";
            default -> Integer.toString(i);
        };
    }

    @Override
    public void start(Stage primaryStage) {
        Button buttonFood = new Button("Food to be placed here");
        buttonFood.setPrefSize(Integer.MAX_VALUE, Integer.MAX_VALUE);

        GridPane gridPaneButtons = new GridPane();

        for (int i = 1; i <= 12; ++i) {
            Button button = new Button(buttonName(i));
            button.setPrefSize(80, 30);
            gridPaneButtons.add(button, (i - 1) % 3, (i - 1) / 3);
        }
        TextField textFieldTime = new TextField("Time to be displayed here");
        textFieldTime.setPrefHeight(30);

        VBox boxMenu = new VBox();
        boxMenu.getChildren().add(textFieldTime);
        boxMenu.getChildren().add(gridPaneButtons);

        BorderPane root = new BorderPane();
        root.setCenter(buttonFood);
        root.setRight(boxMenu);

        Scene scene = new Scene(root, 500, 150);

        primaryStage.setTitle("The front view of a MicroWave oven");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}

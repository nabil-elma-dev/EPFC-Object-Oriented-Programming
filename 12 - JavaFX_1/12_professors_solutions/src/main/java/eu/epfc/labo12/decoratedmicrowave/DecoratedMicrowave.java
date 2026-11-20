package eu.epfc.labo12.decoratedmicrowave;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class DecoratedMicrowave extends Application {

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
        Button buttonFood = new Button();
        Image imageBurger = new Image("file:images/burger.jpg");
        ImageView imageViewBurger = new ImageView(imageBurger);
        imageViewBurger.setFitWidth(100);
        imageViewBurger.setPreserveRatio(true);
        buttonFood.setGraphic(imageViewBurger);
        buttonFood.setPrefSize(200, 150);

        GridPane gridPaneButtons = new GridPane();

        for (int i = 1; i <= 12; ++i) {
            Button button = new Button(buttonName(i));
            button.setPrefSize(80, 30);
            button.setFont(Font.font("Arial", 14));
            if (i == 11)
                button.setStyle("-fx-text-fill: green;");
            else if (i == 12)
                button.setStyle("-fx-text-fill: red;");
            gridPaneButtons.add(button, (i - 1) % 3, (i - 1) / 3);
        }
        TextField textFieldMenu = new TextField("Time to be displayed here");

        textFieldMenu.setPrefHeight(30);

        VBox boxMenu = new VBox();
        boxMenu.getChildren().add(textFieldMenu);
        boxMenu.getChildren().add(gridPaneButtons);

        BorderPane root = new BorderPane();
        root.setLeft(buttonFood);
        root.setCenter(boxMenu);

        Scene scene = new Scene(root);

        primaryStage.setTitle("The front view of a MicroWave oven");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}


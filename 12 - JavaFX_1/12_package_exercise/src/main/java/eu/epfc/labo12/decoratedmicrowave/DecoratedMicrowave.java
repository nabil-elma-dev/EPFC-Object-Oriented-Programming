package eu.epfc.labo12.decoratedmicrowave;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class DecoratedMicrowave extends Application {

    // Tools
    private final Button foodButton = new Button();
    private final TextField timerTxtField = new TextField("Time to be displayed here");

    private final Button btnZero = new Button("0");
    private final Button btnOne = new Button("1");
    private final Button btnTwo = new Button("2");
    private final Button btnThree = new Button("3");
    private final Button btnFour = new Button("4");
    private final Button btnFive = new Button("5");
    private final Button btnSix = new Button("6");
    private final Button btnSeven = new Button("7");
    private final Button btnEight = new Button("8");
    private final Button btnNine = new Button("9");

    private final Button start = new Button("Start");
    private final Button stop = new Button("Stop");
    private final List<Button> listButtons = new ArrayList<>();
    private final Image img = new Image("file:images/burger.jpg");
    private final ImageView imgView = new ImageView(img);

    // Containers
    private final HBox microWave = new HBox();
    private final BorderPane foodPane = new BorderPane();
    private final VBox timerBox = new VBox();

    @Override
    public void start(Stage primaryStage) {

        foodPaneBuilder();
        timerBoxBuilder();

        microWave.getChildren().addAll(foodPane, timerBox);
        Scene scene = new Scene(microWave,600, 200);

        primaryStage.setTitle("The front view of a Microwave oven");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private void foodPaneBuilder() {
        sizingPanes(foodPane);
        foodButton.setPrefSize(foodPane.getPrefWidth(), foodPane.getPrefHeight());
        foodButton.setGraphic(imgView);
        foodPane.setCenter(foodButton);
    }

    private void timerBoxBuilder() {
        sizingPanes(timerBox);
        setUpTimerButtons();
        setUpStartAndEnd();
        timerBox.getChildren().add(timerTxtField);
        timerBox.getChildren().addAll(
                buildTimerBoxRow(btnOne, btnTwo, btnThree),
                buildTimerBoxRow(btnFour, btnFive, btnSix),
                buildTimerBoxRow(btnSeven, btnEight, btnNine),
                buildTimerBoxRow(btnZero, start, stop)
        );
    }

    private HBox buildTimerBoxRow(Button btn1, Button btn2, Button btn3) {
        HBox timerBoxRow = new HBox();
        timerBoxRow.getChildren().addAll(btn1, btn2, btn3);
        return timerBoxRow;
    }

    private void setUpStartAndEnd() {
        start.setTextFill(Color.color(1,0,0));
        start.setStyle("-fx-font-weight: bold;");
        stop.setTextFill(Color.color(0,0.5,0));
        stop.setStyle("-fx-font-weight: bold;");
    }

    private void setUpTimerButtons() {
        sizingTimerButtons(btnZero, btnOne, btnTwo, btnThree, btnFour, btnFive, btnSix, btnSeven, btnEight, btnNine, start, stop);
    }

    private void sizingPanes(Pane paneElem) {
        paneElem.setPrefSize(300, 300);
    }

    private void sizingTimerButtons(Button... buttons) {
        for (Button button : buttons) {
            button.setPrefSize(timerBox.getPrefWidth() / 3, (timerBox.getPrefHeight() - 100) / 4);
        }
    }

}


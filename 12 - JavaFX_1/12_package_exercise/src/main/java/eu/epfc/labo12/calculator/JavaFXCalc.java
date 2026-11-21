package eu.epfc.labo12.calculator;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class JavaFXCalc extends Application {

    public static Label numberOne = new Label("Number 1: ");
    public static Label numberTwo = new Label("Number 2: ");
    public static Label result = new Label("Result: ");

    public static TextField txtOne = new TextField();
    public static TextField txtTwo = new TextField();
    public static TextField txtResult = new TextField();

    public static Button add = new Button("Add");
    public static Button sub = new Button("Subtract");
    public static Button multiply = new Button("Multiply");
    public static Button divide = new Button("Divide");

    public void start(Stage primaryStage) {

        GridPane root = new GridPane();

        HBox firstRow = firstRowBuilder();
        HBox secondRow = secondRowBuilder();

        manageEvents();

        root.add(firstRow, 0, 0);
        root.add(secondRow, 0, 1);

        Scene scene = new Scene(root,600, 80);

        primaryStage.setTitle("JavaFX Calc");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static HBox firstRowBuilder() {
        HBox firstRow = new HBox();

        txtOne.setMaxWidth(50);
        txtTwo.setMaxWidth(50);
        txtResult.setMaxWidth(50);

        firstRow.getChildren().addAll(numberOne, txtOne, numberTwo, txtTwo, result, txtResult);
        return firstRow;
    }

    public static HBox secondRowBuilder() {
        HBox secondRow = new HBox();
        secondRow.getChildren().addAll(add, sub, multiply, divide);
        return secondRow;
    }

    private void manageEvents() {
        add.setOnAction((ActionEvent event) -> {
            txtResult.setText(getResultAccordingOperand(add, txtOne.getText(), txtTwo.getText())
            );
        });
        sub.setOnAction((ActionEvent event) -> {
            txtResult.setText(getResultAccordingOperand(sub, txtOne.getText(), txtTwo.getText())
            );
        });
        multiply.setOnAction((ActionEvent event) -> {
            txtResult.setText(getResultAccordingOperand(multiply, txtOne.getText(), txtTwo.getText())
            );
        });
        divide.setOnAction((ActionEvent event) -> {
            txtResult.setText(getResultAccordingOperand(divide, txtOne.getText(), txtTwo.getText())
            );
        });
    }

    private String getResultAccordingOperand(Button b, String s1, String s2) {
        return switch (b.getText()) {
            case "Add" -> String.valueOf(Double.parseDouble(s1) + Double.parseDouble(s2));
            case "Subtract" -> String.valueOf(Double.parseDouble(s1) - Double.parseDouble(s2));
            case "Multiply" -> String.valueOf(Double.parseDouble(s1) * Double.parseDouble(s2));
            default -> String.valueOf(Double.parseDouble(s1) / Double.parseDouble(s2));
        };
    }

    public static void main(String[] args) {
        launch(args);
    }
}

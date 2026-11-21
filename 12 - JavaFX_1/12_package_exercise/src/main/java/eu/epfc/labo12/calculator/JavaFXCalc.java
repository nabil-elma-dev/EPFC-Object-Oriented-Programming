package eu.epfc.labo12.calculator;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JavaFXCalc extends Application {

    // Tools for row 1
    private final Label numberOne = new Label("Number 1: ");
    private final Label numberTwo = new Label("Number 2: ");
    private final Label result = new Label("Result: ");

    private final TextField txtOne = new TextField();
    private final TextField txtTwo = new TextField();
    private final TextField txtResult = new TextField();

    // Tools for row 2
    private final Button add = new Button("Add");
    private final Button sub = new Button("Subtract");
    private final Button multiply = new Button("Multiply");
    private final  Button divide = new Button("Divide");

    // Containers
    private final HBox firstRow = new HBox();
    private final HBox secondRow = new HBox();
    private final VBox root = new VBox();

    @Override
    public void start(Stage primaryStage) {
    // Phase 0: calling methods to fill firstRow and secondRow HBoxes
        firstRowBuilder();
        secondRowBuilder();

    // Phase 1: adding all to root
        root.getChildren().addAll(firstRow, secondRow);

    // Phase 2: calling manageEvents method to make buttons and text fields above reactive
        manageEvents();

    // Building javaFX page
        Scene scene = new Scene(root,600, 80);

        primaryStage.setTitle("JavaFX Calc");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void firstRowBuilder() {
        txtOne.setMaxWidth(50);
        txtTwo.setMaxWidth(50);
        txtResult.setMaxWidth(50);

        firstRow.getChildren().addAll(numberOne, txtOne, numberTwo, txtTwo, result, txtResult);
    }

    private void secondRowBuilder() {
        secondRow.getChildren().addAll(add, sub, multiply, divide);
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

package eu.epfc.labo12.microwave;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.w3c.dom.Text;

public class Microwave extends Application {
    // Tools
    private final Button foodButton = new Button("Food to be placed here");
    private final TextField timerTxtField = new TextField();

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

    // Containers
    private final HBox microWave = new HBox();
    private final BorderPane food = new BorderPane();
    private final VBox timer = new VBox();

    @Override
    public void start(Stage primaryStage) {

    }

    public static void main(String[] args) {
        launch(args);
    }
}

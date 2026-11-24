package eu.epfc.labo13.view;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import eu.epfc.labo13.model.Circle;
import eu.epfc.labo13.model.Rectangle;
import eu.epfc.labo13.model.ShapeList;

public class FXPaint extends Application {

    private final ShapeList shapeList = new ShapeList();
    private final BorderPane root = new BorderPane();
    private final HBox boxButtons = new HBox();
    private final Button btCircle = new Button("Add a Circle");
    private final Button btRectangle = new Button("Add a Rectangle");
    private final Button btMove = new Button("Move a Shape");
    private final Button btClear = new Button("Clear");
    private final DrawingPane drawingPane = new DrawingPane(shapeList);

    @Override
    public void start(Stage primaryStage) {
        configurePanes();
        addButtonsHandlers();

        Scene scene = new Scene(root, 640, 480);
        primaryStage.setTitle("FXPaint");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void configurePanes() {
        boxButtons.setAlignment(Pos.CENTER);
        boxButtons.setSpacing(20);
        boxButtons.getChildren().addAll(btCircle, btRectangle, btMove, btClear);
        root.setBottom(boxButtons);
        root.setCenter(drawingPane);

        // Just a start to try...
        shapeList.add(new Circle(100, 100, 100));
        shapeList.add(new Rectangle(400, 200, 100, 200));
    }

    private void addButtonsHandlers() {
        btClear.setOnAction((ActionEvent e) -> {
            shapeList.clear();
            drawingPane.repaint();
        });
    }

    public static void main(String[] args) {
        launch(args);
    }

}

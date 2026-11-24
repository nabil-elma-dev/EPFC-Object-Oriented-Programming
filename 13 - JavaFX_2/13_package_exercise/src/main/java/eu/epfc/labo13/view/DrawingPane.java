package eu.epfc.labo13.view;

import javafx.scene.Cursor;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import eu.epfc.labo13.model.Shape;
import eu.epfc.labo13.model.Circle;
import eu.epfc.labo13.model.Rectangle;
import eu.epfc.labo13.model.ShapeList;
import javafx.scene.paint.Paint;

public class DrawingPane extends Pane {
    private final Canvas canvas = new Canvas();
    private final ShapeList shapeList;

    public DrawingPane(ShapeList list) {
        this.shapeList = list;
        canvas.setCursor(Cursor.CROSSHAIR);
        super.getChildren().add(canvas);
    }

    void repaint() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        for (Shape f : shapeList) {
            f.paintOn(gc);
        }
    }

    @Override
    protected void layoutChildren() {
        canvas.setWidth(getWidth());
        canvas.setHeight(getHeight());
        repaint();
    }
}

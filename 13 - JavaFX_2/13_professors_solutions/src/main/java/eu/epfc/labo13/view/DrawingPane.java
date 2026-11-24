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

    private double startX, startY;
    private double x0, y0;

    private Mode mode = Mode.FREE;
    private Shape selection;

    private final Canvas canvas = new Canvas();
    private final ShapeList shapeList;

    public DrawingPane(ShapeList list) {
        this.shapeList = list;

        this.setOnMousePressed((MouseEvent e) -> {
            startX = e.getX();
            startY = e.getY();
            selection = null;
            for (Shape f : shapeList) {
                if (f.isOn(startX, startY)) {
                    selection = f;
                    x0 = selection.getX();
                    y0 = selection.getY();
                }
            }
        });

        this.setOnMouseReleased((MouseEvent e) -> {
            double bottomRightX = e.getX();
            double bottomRightY = e.getY();
            double topLeftX = startX;
            double topLeftY = startY;
            if (bottomRightX < topLeftX) {
                double tmp = topLeftX;
                topLeftX = bottomRightX;
                bottomRightX = tmp;
            }
            if (bottomRightY < topLeftY) {
                double tmp = topLeftY;
                topLeftY = bottomRightY;
                bottomRightY = tmp;
            }
            if (mode == Mode.RECTANGLE) {
                shapeList.add(new Rectangle(topLeftX, topLeftY, bottomRightX - topLeftX, bottomRightY - topLeftY));
            } else if (mode == Mode.CIRCLE) {
                shapeList.add(new Circle(topLeftX, topLeftY, Math.min(bottomRightX - topLeftX, bottomRightY - topLeftY) / 2));
            }
            this.repaint();
        });

        this.setOnMouseDragged((MouseEvent e) -> {
            if (mode == Mode.MOVE && selection != null) {
                selection.moveTo(x0 + e.getX() - startX, y0 + e.getY() - startY);
                repaint();
            } else if (mode == Mode.CIRCLE || mode == Mode.RECTANGLE) {
                drawGhost(e.getX(), e.getY());
            }
        });

        canvas.setCursor(Cursor.CROSSHAIR);
        super.getChildren().add(canvas);
    }

    void setMode(Mode mode) {
        this.mode = mode;
    }

    private void drawGhost(double bottomRightX, double bottomRightY) {
        this.repaint();
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setStroke(Color.GREY);
        double topLeftX = startX, topLeftY = startY;
        if (bottomRightX < startX) {
            double tmp = topLeftX;
            topLeftX = bottomRightX;
            bottomRightX = tmp;
        }
        if (bottomRightY < startY) {
            double tmp = topLeftY;
            topLeftY = bottomRightY;
            bottomRightY = tmp;
        }
        gc.strokeRect(topLeftX, topLeftY, bottomRightX - topLeftX, bottomRightY - topLeftY);
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

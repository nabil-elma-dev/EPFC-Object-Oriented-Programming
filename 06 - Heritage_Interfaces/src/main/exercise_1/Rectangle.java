package main.exercise_1;

public class Rectangle implements TranScalable{

// ATTRIBUTES
    private final Point p;
    private double length, height;

// CONSTRUCTOR
    public Rectangle(int px, int py, int length, int height) {
        this.p = new Point(px, py);
        this.length = length;
        this.height = height;
    }

// METHODS
    // Implemented methods
    @Override
    public void scale(double scaleParam) {
        this.length *= scaleParam;
        this.height *= scaleParam;
    }

    @Override
    public void translate(double xDelta, double yDelta) {
        p.setPx(this.p.getPx() + xDelta);
        p.setPy(this.p.getPy() + yDelta);
    }

    // ToString
    @Override
    public String toString() {
        return "<Rectangle en " + p.toString() +
                " <-> " + length +
                " | " + height +
                ">";
    }
}

package main.exercise_1;

public class Circle implements TranScalable{
// ATTRIBUTES
    private final Point p;
    private double radius;

// CONSTRUCTOR
    public Circle(double px, double py, double radius) {
        this.p = new Point(px, py);
        this.radius = radius;
    }

// METHODS
    // Implemented methods
    @Override
    public void scale(double scaleParam) {
        this.radius *= scaleParam;
    }

    @Override
    public void translate(double px, double py) {
        p.setPx(px);
        p.setPy(py);
    }

    // toSTring

    @Override
    public String toString() {
        return "<Cercle " + this.p.toString() + " <-> " + this.radius + ">";
    }
}

package main.exercise_1;

public class Circle extends Shape{
// ATTRIBUTES
    private double radius;

// CONSTRUCTOR
    public Circle(double px, double py, double radius) {
        super(px, py);
        this.radius = radius;
    }

// METHODS
    // Implemented methods
    @Override
    public void scale(double scaleParam) {
        this.radius *= scaleParam;
    }

    // toSTring
    @Override
    public String toString() {
        return "<Cercle " + this.getP().toString() + " <-> " + this.radius + ">";
    }
}

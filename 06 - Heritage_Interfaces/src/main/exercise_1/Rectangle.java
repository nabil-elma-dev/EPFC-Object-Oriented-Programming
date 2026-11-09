package main.exercise_1;

public class Rectangle extends Shape{

// ATTRIBUTES
    private double length, height;

// CONSTRUCTOR
    public Rectangle(int px, int py, int length, int height) {
        super(px, py);
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

    // ToString
    @Override
    public String toString() {
        return "<Rectangle en " + this.getP().toString() +
                " <-> " + length +
                " | " + height +
                ">";
    }
}

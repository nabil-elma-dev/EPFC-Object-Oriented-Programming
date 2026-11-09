package main.exercise_1;

public class Point {
// ATTRIBUTES
    private double px, py;

// CONSTRUCTOR
    public Point(double px, double py) {
        this.px = px;
        this.py = py;
    }

// ACCESSORS
    // Getters
    public double getPx() {
        return px;
    }
    public double getPy() {
        return py;
    }

    // Setters
    public void setPx(double px) {
        this.px = px;
    }
    public void setPy(double py) {
        this.py = py;
    }

    // toSTring

    @Override
    public String toString() {
        return "(" + this.px + ", " + this.py + ")";
    }
}

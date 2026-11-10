package main.exercise_1;

public class Point implements Translatable {
// ATTRIBUTES
    private double px, py;

// CONSTRUCTOR
    public Point(double px, double py) {
        this.px = px;
        this.py = py;
    }

// ACCESSORS
    @Override
    public double getPx() {
        return this.px;
    }
    @Override
    public double getPy() {
        return this.py;
    }
    @Override
    public void setPx(double newPx) {
        this.px = newPx;
    }
    @Override
    public void setPy(double newPy) {
        this.py = newPy;
    }

// METHODS
    // toSTring
    @Override
    public String toString() {
        return "(" + this.px + ", " + this.py + ")";
    }
}

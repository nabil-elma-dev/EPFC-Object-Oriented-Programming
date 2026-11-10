package main.exercise_1;

public abstract class Shape implements TranScalable{
    private final Point p;

    public Shape(double px, double py) {
        this.p = new Point(px, py);
    }

    public Point getP() {
        return p;
    }

// ACCESSORS (implemented from Translatable interface extending Positionable interface)
    @Override
    public double getPx() {
        return this.p.getPx();
    }
    @Override
    public double getPy() {
        return this.p.getPy();
    }
    @Override
    public void setPx(double newPx) {
        this.p.setPx(newPx);
    }
    @Override
    public void setPy(double newPy) {
        this.p.setPy(newPy);
    }
}

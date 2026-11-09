package main.exercise_1;

public abstract class Shape implements TranScalable{
    private final Point p;

    public Shape(double px, double py) {
        this.p = new Point(px, py);
    }

    public Point getP() {
        return p;
    }

    @Override
    public void translate(double xDelta, double yDelta) {
        p.setPx(this.p.getPx() + xDelta);
        p.setPy(this.p.getPy() + yDelta);
    }
}

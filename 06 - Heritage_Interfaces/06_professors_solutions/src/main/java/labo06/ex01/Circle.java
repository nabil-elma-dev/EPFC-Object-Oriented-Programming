package labo06.ex01;


public class Circle implements TranScalable {
    private double radius;
    private final Point center;

    public Circle(double x, double y, double radius) {
        center = new Point(x, y);
        this.radius = radius;
    }

    public Circle(double radius) {
        this(0, 0, radius);
    }

    @Override
    public void scale(double scaleFactor) {
        radius *= scaleFactor;
    }

    @Override
    public String toString() {
        return "<Cercle " + center + " <-> " +
                radius + ">";
    }

    @Override
    public double getX() {
        return center.getX();
    }

    @Override
    public void setX(double x) {
        center.setX(x);
    }

    @Override
    public double getY() {
        return center.getY();
    }

    @Override
    public void setY(double y) {
        center.setY(y);
    }

    public double getRadius() {
        return this.radius;
    }

}

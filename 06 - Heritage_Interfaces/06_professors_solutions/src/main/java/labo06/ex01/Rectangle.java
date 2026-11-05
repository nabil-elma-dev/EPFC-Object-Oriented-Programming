
package labo06.ex01;


public class Rectangle implements TranScalable {
    private final Point origin;
    private double width, height;

    public Rectangle(double x, double y, double width, double height) {
        origin = new Point(x, y);
        this.width = width;
        this.height = height;
    }

    @Override
    public void scale(double scaleFactor) {
        width *= scaleFactor;
        height *= scaleFactor;
    }

    @Override
    public String toString() {
        return "<Rectangle en " + origin + " <-> " +
                width + " | " +
                height + ">";
    }

    @Override
    public double getX() {
        return origin.getX();
    }

    @Override
    public double getY() {
        return origin.getY();
    }

    @Override
    public void setX(double x) {
        origin.setX(x);
    }

    @Override
    public void setY(double y) {
        origin.setY(y);
    }

    public double getWidth() {
        return this.width;
    }

    public double getHeight() {
        return this.height;
    }
}

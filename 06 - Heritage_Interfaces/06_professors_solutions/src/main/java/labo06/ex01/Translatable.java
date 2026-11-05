
package labo06.ex01;


public interface Translatable extends Positionnable {
    default void translate(double dirX, double dirY) {
        setX(getX() + dirX);
        setY(getY() + dirY);
    }
}

package main.exercise_1;

public interface Translatable extends Positionable {
    default void translate (double deltaPx, double deltaPy) {
        setPx(getPx() + deltaPx);
        setPy(getPy() + deltaPy);
    };
}

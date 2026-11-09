package test.exercise_1;
import static org.junit.Assert.*;

import main.exercise_1.Circle;
import main.exercise_1.Rectangle;
import org.junit.Test;

public class TestEx1 {
    @Test
    public void testTranslate() {
        // test on Rectangle
        Rectangle r = new Rectangle(1,2, 5, 7);
        assertEquals(1, r.getP().getPx(), 0.0);
        assertEquals(2, r.getP().getPy(), 0.0);
        r.translate(2, 2);
        assertEquals(3, r.getP().getPx(), 0.0);
        assertEquals(4, r.getP().getPy(), 0.0);

        // test on Circle
        Circle c = new Circle(3,4, 6);
        assertEquals(3, c.getP().getPx(), 0.0);
        assertEquals(4, c.getP().getPy(), 0.0);
        c.translate(3, 1);
        assertEquals(6, c.getP().getPx(), 0.0);
        assertEquals(5, c.getP().getPy(), 0.0);
    }

    @Test
    public void testScale() {
        // test on Rectangle
        Rectangle r = new Rectangle(1,2, 5, 7);
        assertEquals(5, r.getLength(), 0.0);
        assertEquals(7, r.getHeight(), 0.0);
        r.scale(2);
        assertEquals(10, r.getLength(), 0.0);
        assertEquals(14, r.getHeight(), 0.0);

        // test on Circle
        Circle c = new Circle(3,4, 6);
        assertEquals(6, c.getRadius(), 0.0);
        c.scale(1.5);
        assertEquals(9, c.getRadius(), 0.0);
    }
}

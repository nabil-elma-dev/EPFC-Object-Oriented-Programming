package labo06.ex01;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TranScalableTest {

    @Test
    public void testTranscalables() {
        List<TranScalable> ls = new ArrayList<>();
        // Coin supérieur gauche en (1, 2), largeur 3, hauteur 4
        ls.add(new Rectangle(1, 2, 3, 4));
        // Centre en (2, 1), rayon 4
        ls.add(new Circle(2, 1, 4));
        ls.add(new Rectangle(6, 3, 2, 2));

        assertTrue(1 == ls.get(0).getX());
        assertTrue(2 == ls.get(0).getY());
        assertTrue(3 == ((Rectangle) ls.get(0)).getWidth());
        assertTrue(4 == ((Rectangle) ls.get(0)).getHeight());

        assertTrue(2 == ls.get(1).getX());
        assertTrue(1 == ls.get(1).getY());
        assertTrue(4 == ((Circle) ls.get(1)).getRadius());

        assertTrue(6 == ls.get(2).getX());
        assertTrue(3 == ls.get(2).getY());
        assertTrue(2 == ((Rectangle) ls.get(2)).getWidth());
        assertTrue(2 == ((Rectangle) ls.get(2)).getHeight());

        for (TranScalable forme : ls)
            forme.translate(1, 2);

        assertTrue(2 == ls.get(0).getX());
        assertTrue(4 == ls.get(0).getY());

        assertTrue(3 == ls.get(1).getX());
        assertTrue(3 == ls.get(1).getY());

        assertTrue(7 == ls.get(2).getX());
        assertTrue(5 == ls.get(2).getY());


        for (TranScalable forme : ls)
            forme.scale(2);

        assertTrue(6 == ((Rectangle) ls.get(0)).getWidth());
        assertTrue(8 == ((Rectangle) ls.get(0)).getHeight());

        assertTrue(8 == ((Circle) ls.get(1)).getRadius());

        assertTrue(4 == ((Rectangle) ls.get(2)).getWidth());
        assertTrue(4 == ((Rectangle) ls.get(2)).getHeight());

    }

}
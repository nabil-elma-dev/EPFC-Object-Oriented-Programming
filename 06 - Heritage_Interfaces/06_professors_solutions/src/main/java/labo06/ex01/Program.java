
package labo06.ex01;


import java.util.*;


public class Program {

    public static void main(String[] args) {
        List<TranScalable> ls = new ArrayList<>();

        // Coin supérieur gauche en (1, 2), largeur 3, hauteur 4
        ls.add(new Rectangle(1, 2, 3, 4));

        // Centre en (2, 1), rayon 4
        ls.add(new Circle(2, 1, 4));

        ls.add(new Rectangle(6, 3, 2, 2));

        System.out.println(ls);

        for (TranScalable forme : ls)
            forme.translate(1, 2);

        System.out.println(ls);

        for (TranScalable forme : ls)
            forme.scale(2);

        System.out.println(ls);
    }
}

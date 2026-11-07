package main;

import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main ( String [] args ) {
        List<TranScalable> ls = new ArrayList<>();

        /*
        RECTANGLE
            top-left angle in 1,2
            length: 3
            width: 4
        CIRCLE
            center in 2,1
            radius: 4
        */

        ls.add(new Rectangle(1, 2, 3, 4));


        ls.add(new Circle(2, 1, 4));
        ls.add(new Rectangle(6, 3, 2, 2));
        System.out.println(ls);
        for(TranScalable forme : ls)
            forme.translate(1, 2);
        System.out.println(ls);
        for(TranScalable forme : ls)
            forme.scale (2);
        System.out.println(ls);
    }
}

package main.java.labo05;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Program {
    public static Random generator = new Random();

    public static void main(String[] args) {
        // generateRandomNumbers();
        List<Integer> ls = new ArrayList<>();
        ls.add(1);
        ls.add(2);
        ls.add(3);
        ls.add(4);
        ls.add(5);
        show(ls); // printing list before shuffling
        shuffle(ls);
        show(ls); // printing list after shuffling
    }

    public static <E> void shuffle(List<E> ls) {
        for (int i = 0; i < ls.size(); ++i) {
            E currentElem = ls.get(i);
            int randomPos = generator.nextInt(i, ls.size());

            ls.set(i, ls.get(randomPos));
            ls.set(randomPos, currentElem);
        }
    }

    public static <E> void show (List<E> ls) {
        for (E elem : ls) {
            System.out.print(elem + " ");
        }
        System.out.println();
    }

    // Testing random generator
    public static void generateRandomNumbers() {
        for (int k = 0; k < 5; ++k) {
            System.out.println(generator.nextInt(100));
        }
    }
}

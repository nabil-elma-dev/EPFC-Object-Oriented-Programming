package labo05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Program {
    public static <E> void swap(E[] array, int i, int j) {
        E tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static <E> void shuffle(E[] array) {
        Random r = new Random();
        for (int i = 0; i < array.length - 1; i++) {
            int position = r.nextInt(array.length - i) + i;
            swap(array, i, position);
        }
    }

    public static <E> void print(E[] array) {
        for (E elem : array)
            System.out.print(elem + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        Date d1 = new Date(1, 1, 1);
        Date d2 = new Date(2, 2, 2);
        Date d3 = new Date(3, 3, 3);
        Date d4 = new Date(4, 4, 4);

        Date[] tab = {d1, d2, d3, d4};
        print(tab);

        System.out.println("==========================");

        shuffle(tab);
        print(tab);

        System.out.println("==========================");

        Integer[] tab2 = {1, 2, 3, 4};
        print(tab2);

        System.out.println("==========================");

        shuffle(tab2);
        print(tab2);

        System.out.println("==========================");

        List<Date> l = new ArrayList<>();
        l.add(d3);
        l.add(d1);
        l.add(d2);
        l.add(d4);

        System.out.println(l);

        Collections.sort(l);
        System.out.println("==========================");
        System.out.println(l);
    }
}
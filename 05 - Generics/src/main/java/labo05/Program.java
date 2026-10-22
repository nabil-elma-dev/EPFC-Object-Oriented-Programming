package main.java.labo05;

import java.util.*;

public class Program {
    public static Random generator = new Random();

    public static void main(String[] args) {
        // generateRandomNumbers();
//        List<Integer> ls = new ArrayList<>();
//        ls.add(1);
//        ls.add(2);
//        ls.add(3);
//        ls.add(4);
//        ls.add(5);
//        show(ls); // printing list before shuffling
//        shuffle(ls);
//        show(ls); // printing list after shuffling

//        List<Date> dates = new ArrayList<>();
//        dates.add(new Date(1,5,1998));
//        dates.add(new Date(18,4,1999));
//        dates.add(new Date(22,10,1967));
//        dates.add(new Date(10,7,1964));
//
//        show(dates); // showing dates before sorting
//        Collections.sort(dates);
//        show(dates); // showing dates after sorting

        List<Person> people = new ArrayList<>();
        people.add(new Person("Nabil", "El Mahfoudi", 1, 5, 1998));
        people.add(new Person("Mariam", "El Mahfoudi", 18, 4, 1999));
        people.add(new Person("Abdelkrim", "El Mahfoudi", 10, 7, 1964));
        people.add(new Person("Khadija", "Naqi", 22, 10, 1967));

        show(people); // printing people before sorting
        Collections.sort(people);
        show(people); // printing people after sorting
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
            System.out.println(elem);
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

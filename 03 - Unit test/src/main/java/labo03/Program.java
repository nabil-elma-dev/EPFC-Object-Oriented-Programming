package main.java.labo03;

import java.security.PublicKey;

public class Program {
    public static void main(String[] args) {
//        Date[] dates = {
//                new Date(22, 10, 1967),
//                new Date(1, 5, 1998),
//                new Date(10,7,1964),
//                new Date(18,4,1999)
//        };
//        printArray(dates);
//        sortArray(dates);
//        System.out.println();
//        printArray(dates);

        Person[] people = {
                new Person("Nabil", "El Mahfoudi", 1,5,1998),
                new Person("Francesco", "Seminara", 4, 4, 1997),
                new Person("Umberto", "Arcidiacono", 25, 12, 1998)
        };
        printArray(people);
        sortArray(people);
        System.out.println();
        printArray(people);
    }

    public static void printArray(Person[] people) {
        for (Person p : people) {
            System.out.println(p);
        }
    }

    public static void printArray(Date[] dates) {
        for (Date d : dates) {
            System.out.println(d);
        }
    }

    public static void sortArray(Person[] people) {
        for (int i = 0; i < people.length; ++i) {
            int priorityDateIndex = i;
            for (int j = i + 1; j < people.length; ++j) {
                if (people[priorityDateIndex].compareFull(people[j]) < 0) {
                    priorityDateIndex = j;
                }
            }
            Person p = people[i];
            people[i] = people[priorityDateIndex];
            people[priorityDateIndex] = p;
        }
    }

    public static void sortArray(Date[] dates) {
        for (int i = 0; i < dates.length; ++i) {
            int priorityDateIndex = i;
            for (int j = i + 1; j < dates.length; ++j) {
                if (dates[priorityDateIndex].compareTo(dates[j]) < 0) {
                    priorityDateIndex = j;
                }
            }
            Date d = dates[i];
            dates[i] = dates[priorityDateIndex];
            dates[priorityDateIndex] = d;
        }
    }
}

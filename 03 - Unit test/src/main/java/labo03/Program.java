package main.java.labo03;

import java.security.PublicKey;

public class Program {
    public static void main(String[] args) {
        Date[] dates = {
                new Date(22, 10, 1967),
                new Date(1, 5, 1998),
                new Date(10,7,1964),
                new Date(18,4,1999)
        };
        printArray(dates);
        sortArray(dates);
        System.out.println();
        printArray(dates);
    }

    public static void printArray(Date[] dates) {
        for (Date d : dates) {
            System.out.println(d);
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

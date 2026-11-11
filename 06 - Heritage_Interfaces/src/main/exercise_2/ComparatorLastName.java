package main.exercise_2;

import java.util.Comparator;

public class ComparatorLastName implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        return p1.getLastName().compareToIgnoreCase(p2.getLastName());
    }
}

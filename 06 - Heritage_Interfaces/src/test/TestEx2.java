package test;
import static org.junit.Assert.*;

import main.exercise_2.ComparatorFirstName;
import main.exercise_2.ComparatorLastName;
import main.exercise_2.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestEx2 {

    @Test
    public void testLastNameSorting() {
        Person p1 = new Person("A", "b1");
        Person p2 = new Person("A", "b2");
        Person p3 = new Person("B", "a1");
        Person p4 = new Person("B", "a2");

        List<Person> ls = new ArrayList<>();

        ls.add(p1);
        ls.add(p2);
        ls.add(p3);
        ls.add(p4);

        ls.sort(new ComparatorLastName());

        assertEquals(p3, ls.get(0));
        assertEquals(p4, ls.get(1));
        assertEquals(p1, ls.get(2));
        assertEquals(p2, ls.get(3));
    }

    @Test
    public void testFirstNameSorting() {
        Person p1 = new Person("A", "b1");
        Person p2 = new Person("A", "b2");
        Person p3 = new Person("B", "a1");
        Person p4 = new Person("B", "a2");

        List<Person> ls = new ArrayList<>();

        ls.add(p1);
        ls.add(p2);
        ls.add(p3);
        ls.add(p4);

        ls.sort(new ComparatorFirstName());

        assertEquals(p1, ls.get(0));
        assertEquals(p2, ls.get(1));
        assertEquals(p3, ls.get(2));
        assertEquals(p4, ls.get(3));
    }
}

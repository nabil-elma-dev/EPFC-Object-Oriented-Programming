package labo06.ex02;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ListSortTest {
    @Test
    public void testSort() {
        Person p1 = new Person("A", "a1");
        Person p2 = new Person("B", "b1");
        Person p3 = new Person("A", "a2");
        Person p4 = new Person("B", "b2");

        List<Person> li = new ArrayList<>();
        li.add(p1);
        li.add(p2);
        li.add(p3);
        li.add(p4);

        Collections.sort(li, new ComparatorPersonFirstName());
        assertEquals(p1, li.get(0));
        assertEquals(p3, li.get(1));
        assertEquals(p2, li.get(2));
        assertEquals(p4, li.get(3));

        Collections.sort(li, new ComparatorPersonLastName());
        assertEquals(p1, li.get(0));
        assertEquals(p3, li.get(1));
        assertEquals(p2, li.get(2));
        assertEquals(p4, li.get(3));
    }
}

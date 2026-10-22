package labo05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import static org.junit.Assert.*;

import org.junit.Test;


public class Labo05Test {

    @Test
    public void testDateComparable() {
        Date d1 = new Date(1, 1, 2000);
        Date d2 = new Date(2, 1, 2000);
        Date d3 = new Date(2, 1, 2000);
        assertTrue(d1.compareTo(d2) < 0);
        assertTrue(d1.equals(d1));
        assertTrue(d1.compareTo(d1) == 0);
        assertTrue(d2.equals(d3));
        assertTrue(d2.compareTo(d3) == 0);
        assertTrue(d2.compareTo(d1) > 0);
    }

    @Test
    public void testPersonComparable() {
        Person p1 = new Person("a", "b", 1, 1, 1);
        Person p2 = new Person("b", "c", 1, 1, 1);
        Person p3 = new Person("c", "d", 2, 2, 2);
        assertTrue(p1.compareTo(p2) == 0);
        assertTrue(p2.compareTo(p1) == 0);
        assertTrue(p1.compareTo(p3) > 0);
        assertTrue(p3.compareTo(p1) < 0);
    }

    @Test
    public void testSortDate() {
        Date d1 = new Date(1, 1, 1);
        Date d2 = new Date(2, 2, 2);
        Date d3 = new Date(3, 3, 3);
        List<Date> li = new ArrayList<>();
        li.add(d3);
        li.add(d2);
        li.add(d1);
        Collections.sort(li);
        assertEquals(d1, li.get(0));
        assertEquals(d2, li.get(1));
        assertEquals(d3, li.get(2));
    }

    @Test
    public void testSortPerson() {
        Person p1 = new Person("a", "b", 1, 1, 1);
        Person p2 = new Person("b", "c", 1, 1, 1);
        Person p3 = new Person("c", "d", 2, 2, 2);
        Person p4 = new Person("c", "d", 3, 3, 3);
        List<Person> li = new LinkedList<>();
        li.add(p3);
        li.add(p2);
        li.add(p4);
        li.add(p1);
        Collections.sort(li); //ce tri est stable
        assertEquals(p4, li.get(0));
        assertEquals(p3, li.get(1));
        assertEquals(p2, li.get(2));
        assertEquals(p1, li.get(3));
    }

    @Test
    public void testSet() {
        Set<Date> s = new TreeSet<>();
        s.add(new Date(2, 2, 2));
        s.add(new Date(1, 1, 1));
        s.add(new Date(1, 1, 1));
        assertEquals(2, s.size());
        //un Set n'est pas ordonné, on le copie donc dans une liste (ordonnée)
        //afin de tester que ce Set est bien trié.
        List<Date> copy = new LinkedList<>();

        for (Date d : s)
            copy.add(d);

        assertEquals(new Date(1, 1, 1), copy.get(0));
        assertEquals(new Date(2, 2, 2), copy.get(1));
    }


}

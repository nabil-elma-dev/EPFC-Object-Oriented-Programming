package labo06.ex03;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

import static org.junit.Assert.*;

public class TreeSetTest {

    @Test
    public void testTreeSetComparator() {
        Set<Person> s = new TreeSet<Person>(new ComparatorPerson());
        s.add(new Person("Donald", "Knuth", 10, 1, 1938));
        s.add(new Person("Donald", "Knuth", 10, 1, 1940));
        s.add(new Person("Dennis", "Ritchie", 9, 9, 1941));
        s.add(new Person("Linus", "Torvalds", 28, 12, 1969));
        s.add(new Person("James", "Gosling", 19, 5, 1955));
        s.add(new Person("Roulio", "Gosling", 19, 5, 1955));
        s.add(new Person("Edsger", "Dijkstra", 11, 5, 1930));
        s.add(new Person("Tony", "Hoare", 11, 1, 1934));

        //copie du set dans une list pour avoir l'accès indexé et donc constater le tri
        List<Person> l = new LinkedList<>(s);

        assertEquals(new Person("Edsger", "Dijkstra", 11, 5, 1930), l.get(0));
        assertEquals(new Person("James", "Gosling", 19, 5, 1955), l.get(1));
        assertEquals(new Person("Roulio", "Gosling", 19, 5, 1955), l.get(2));
        assertEquals(new Person("Tony", "Hoare", 11, 1, 1934), l.get(3));
        assertEquals(new Person("Donald", "Knuth", 10, 1, 1940), l.get(4));
        assertEquals(new Person("Donald", "Knuth", 10, 1, 1938), l.get(5));
        assertEquals(new Person("Dennis", "Ritchie", 9, 9, 1941), l.get(6));
        assertEquals(new Person("Linus", "Torvalds", 28, 12, 1969), l.get(7));
    }

}

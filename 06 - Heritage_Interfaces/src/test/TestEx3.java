package test;
import static org.junit.Assert.*;

import main.exercise_2_n_3.ComparatorFirstName;
import main.exercise_2_n_3.Person;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class TestEx3 {
    @Test
    public void testTreeSet() {
        Person p1 = new Person("B", "B");
        Person p2 = new Person("A", "A");
        Person p3 = new Person("C", "C");
        Set<Person> treeSetPeople = new TreeSet<>(new ComparatorFirstName()); // setting ComparatorFirstName() as criteria to sort the treeset
        treeSetPeople.add(p1);
        assertEquals(1, treeSetPeople.size());
        treeSetPeople.add(p1);
        assertEquals(1, treeSetPeople.size()); // 1 value per key

        treeSetPeople.add(p2);
        treeSetPeople.add(p3);
        assertEquals(3, treeSetPeople.size()); // 1 value per key

        List<Person> listPeople = new LinkedList<>(treeSetPeople);
        assertEquals(p2, listPeople.get(0));
        assertEquals(p1, listPeople.get(1));
        assertEquals(p3, listPeople.get(2));
    }

}

package test.java.labo03;
import static org.junit.Assert.*;

import main.java.labo03.Date;
import main.java.labo03.Person;
import main.java.labo03.Program;
import org.junit.Test;

public class PersonTest {
    @Test(expected = RuntimeException.class)
    public void testPersonConstructionGoesWrong() {
        Person p = new Person("Wario", "Mario", 31, 11, 2026);
    }

    @Test
    public void testGetAge() {
        Person p = new Person("Nabil", "El Mahfoudi", 1, 5, 1998);
        assertNotEquals(28, p.getAge(new Date(30, 4, 2026)));
        assertEquals(28, p.getAge(new Date(1, 5, 2026)));
    }

    @Test
    public void testPeople() {
        Person p = new Person("Nabil", "El Mahfoudi", 1, 5, 1998);
        Person pDitto = new Person("Nabil", "El Mahfoudi", 1, 5, 1998);
            assertEquals(p, pDitto);
    }

    @Test
    public void testPeopleArray() {
        Person[] people = {
                new Person("Nabil", "El Mahfoudi", 1,5,1998),
                new Person("Francesco", "Seminara", 4, 4, 1997),
                new Person("Umberto", "Arcidiacono", 25, 12, 1998)
        };
        Program.sortArray(people);
        assertEquals(new Person("Francesco", "Seminara", 4, 4,1997), people[0]);
        assertEquals(new Person("Nabil", "El Mahfoudi", 1, 5,1998), people[1]);
        assertEquals(new Person("Umberto", "Arcidiacono", 25, 12,1998), people[2]);
    }
}

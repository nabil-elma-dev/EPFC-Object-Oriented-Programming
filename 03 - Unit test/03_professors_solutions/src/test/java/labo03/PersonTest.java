package labo03;

import java.util.Random;

import org.junit.Test;

import static org.junit.Assert.*;

public class PersonTest {

    @Test(expected = RuntimeException.class)
    public void testPersonConstructorWithFalseDate() {
        new Person("Jean", "Dupont", 30, 2, 2013);
    }

    @Test
    public void testGetAge() {
        Person person = new Person("a", "b", 13, 4, 1984);
        Date referenceDate = new Date(14, 11, 2013);
        assertEquals(29, person.getAgeAt(referenceDate));
    }

    @Test
    public void testEquals() {
        Person p1 = new Person("Jean", "Dupont", 1, 2, 2013);
        Person p2 = new Person("Jean", "Dupont", 1, 2, 2013);
        Person p3 = new Person("Jean", "Dupont", 2, 2, 2013);

        assertEquals(p1, p2);
        assertTrue(!p1.equals(p3));
    }

    @Test
    public void testCompareTo() {
        Person p1 = new Person("Jean", "Dupont", 1, 2, 2013);
        Person p2 = new Person("Jean", "Dupont", 1, 2, 2013);
        Person p3 = new Person("Jean", "Dupont", 2, 2, 2013);

        assertTrue(p1.compareTo(p2) == 0);
        assertTrue(p1.compareTo(p3) > 0);
        assertTrue(p3.compareTo(p1) < 0);
    }

    @Test
    public void testSort() {
        Person[] arr = {
                new Person("A", "B", 2, 2, 2005),
                new Person("A", "B", 31, 12, 2011),
                new Person("A", "B", 21, 1, 2012),
                new Person("A", "B", 1, 3, 2012),
                new Person("A", "B", 1, 1, 2012),
                new Person("A", "B", 29, 2, 2012),
        };
        Program.sort(arr);
        assertEquals(new Person("A", "B", 2, 2, 2005), arr[5]);
        assertEquals(new Person("A", "B", 31, 12, 2011), arr[4]);
        assertEquals(new Person("A", "B", 1, 1, 2012), arr[3]);
        assertEquals(new Person("A", "B", 21, 1, 2012), arr[2]);
        assertEquals(new Person("A", "B", 29, 2, 2012), arr[1]);
        assertEquals(new Person("A", "B", 1, 3, 2012), arr[0]);
    }

    private static boolean isSorted(Person[] array) {
        for (int i = 0; i < array.length - 1; ++i)
            if (array[i].compareTo(array[i + 1]) > 0)
                return false;
        return true;
    }

    private static final Random rd = new Random();

    private static String randomShortString() {
        char[] data = {(char) (rd.nextInt(5) + 65), (char) (rd.nextInt(5) + 65)};
        return new String(data);
    }

    private static Person[] randomPersonArray() {
        Person[] array = new Person[rd.nextInt(10)];
        for (int i = 0; i < array.length; ++i) {
            array[i] = new Person(randomShortString(),
                    randomShortString(),
                    rd.nextInt(28) + 1,
                    rd.nextInt(12) + 1,
                    rd.nextInt(10) + 1985
            );
        }
        return array;
    }

    private static void print(Person[] arr) {
        for (int i = 0; i < arr.length; ++i)
            System.out.println(arr[i] + " ");
        System.out.println("");
    }

    @Test
    public void testRandomSort() {
        for (int i = 0; i < 100000; ++i) {
            Person[] arr = randomPersonArray();
            Program.sort(arr);
            assertTrue(isSorted(arr));
        }
    }

}

package labo03;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Random;

import org.junit.Test;

import static org.junit.Assert.*;

public class DateTest {

    @Test
    public void testIncrementSimple() {
        Date d = new Date(1, 1, 2024);
        d.increment();
        assertEquals(2, d.getDay());
        assertEquals(1, d.getMonth());
        assertEquals(2024, d.getYear());
    }

    @Test
    public void testIncrementEndMonth() {
        Date d = new Date(31, 1, 2012);
        d.increment();
        assertEquals(1, d.getDay());
        assertEquals(2, d.getMonth());
        assertEquals(2012, d.getYear());
    }

    @Test
    public void testIncrementEndYear() {
        Date d = new Date(31, 12, 2012);
        d.increment();
        assertEquals(1, d.getDay());
        assertEquals(1, d.getMonth());
        assertEquals(2013, d.getYear());
    }

    @Test(expected = RuntimeException.class)
    public void testConstructorInvalidMonth() {
        new Date(1, -1, 2012);
    }

    @Test(expected = RuntimeException.class)
    public void testConstructorInvalidMonth1() {
        new Date(1, 0, 2012);
    }

    @Test(expected = RuntimeException.class)
    public void testConstructorInvalidMonth2() {
        new Date(1, 13, 2012);
    }

    @Test
    public void testConstructorValid() {
        Date d = new Date(16, 2, 2012);
        assertEquals(16, d.getDay());
        assertEquals(2, d.getMonth());
        assertEquals(2012, d.getYear());
    }

    @Test
    public void testFebruaryLeapYear2012() {
        Date d = new Date(29, 2, 2012);
        assertNotNull(d);
        d.increment();
        assertEquals(1, d.getDay());
        assertEquals(3, d.getMonth());
    }

    @Test
    public void testFebruaryLeapYear2000() {
        Date d = new Date(29, 2, 2000);
        assertEquals(29, d.getDay());
        assertEquals(2, d.getMonth());
        assertEquals(2000, d.getYear());
    }

    @Test(expected = RuntimeException.class)
    public void testFebruaryLeapYear1900() {
        new Date(29, 2, 1900);
    }

    @Test
    public void testFebruary2012Increment() {
        Date d = new Date(29, 2, 2012);
        d.increment();
        assertEquals(1, d.getDay());
        assertEquals(3, d.getMonth());
    }

    @Test
    public void testFebruary1900Increment() {
        Date d = new Date(28, 2, 1900);
        d.increment();
        assertEquals(1, d.getDay());
        assertEquals(3, d.getMonth());
    }

    @Test
    public void testToString() {
        Date d = new Date(1, 3, 2012);
        assertEquals("Jeudi 1 Mars 2012 le 61-ième jour de l'année",
                d.toString());
    }

    @Test(expected = RuntimeException.class)
    public void testSetYearLeapToNotLeap() {
        Date d = new Date(29, 2, 2012);
        d.setYear(2011);
    }

    @Test(expected = RuntimeException.class)
    public void testSetMonthToSmaller() {
        Date d = new Date(31, 1, 2012);
        d.setMonth(2);
    }

    @Test
    public void testNoArgConstrutor() {
        Date d = new Date();
        assertTrue(d.getDay() == LocalDate.now().getDayOfMonth());
        assertTrue(d.getMonth() == LocalDate.now().getMonthValue());
        assertTrue(d.getYear() == LocalDate.now().getYear());
    }

    @Test
    public void testDayOfYear() {
        assertTrue(new Date(1, 1, 2012).dayOfYear() == 1);
        assertTrue(new Date(1, 3, 2012).dayOfYear() == 61);
        assertTrue(new Date(1, 3, 2013).dayOfYear() == 60);
        assertTrue(new Date(31, 12, 2012).dayOfYear() == 366);
        assertTrue(new Date(31, 12, 2013).dayOfYear() == 365);
    }

    @Test
    public void testDayOfWeek() {
        assertTrue(new Date(1, 1, 2012).dayOfWeek() == 6); // Dimanche
        assertTrue(new Date(29, 2, 2012).dayOfWeek() == 2); // Mercredi
    }

    @Test
    public void testIsLeapYear() {
        assertTrue(!Date.isLeapYear(2011));
        assertTrue(Date.isLeapYear(2012));
        assertTrue(!Date.isLeapYear(1900)); // Divisible par 100
        assertTrue(Date.isLeapYear(2000));  // Divisible par 400
    }

    @Test
    public void testDateEquals() {
        assertEquals(new Date(1, 1, 2012), new Date(1, 1, 2012));
    }

    @Test
    public void testDateNotEquals() {
        assertNotEquals(new Date(1, 1, 2012), new Date(1, 1, 2013));
    }

    @Test
    public void testDateNotEqualsToNull() {
        assertFalse(new Date(1, 1, 2012).equals(null));
    }

    @Test
    public void testDateNotEqualsToPerson() {
        assertFalse(new Date(1, 1, 2012).equals(new Person("a", "b", 1, 1, 2012)));
    }

    @Test
    public void testDateCompareTo() {
        assertTrue(new Date(1, 1, 2012).compareTo(new Date(1, 1, 2012)) == 0);
        assertTrue(new Date(31, 12, 2011).compareTo(new Date(1, 1, 2012)) < 0);
    }

    @Test
    public void testSort() {
        Date[] array = {
                new Date(2, 2, 2005),
                new Date(31, 12, 2011),
                new Date(21, 1, 2012),
                new Date(1, 3, 2012),
                new Date(1, 1, 2012),
                new Date(29, 2, 2012),};
        Program.sort(array);
        assertEquals(new Date(2, 2, 2005), array[0]);
        assertEquals(new Date(31, 12, 2011), array[1]);
        assertEquals(new Date(1, 1, 2012), array[2]);
        assertEquals(new Date(21, 1, 2012), array[3]);
        assertEquals(new Date(29, 2, 2012), array[4]);
        assertEquals(new Date(1, 3, 2012), array[5]);
    }

    @Test
    public void testSortEnhanced() {
        for (int i = 0; i < 10000; ++i) {
            Date[] arr = randomDates();
            Date[] copy = Arrays.copyOf(arr, arr.length);// Copie "superficielle"
            Program.sort(arr);
            assertTrue(ordered(arr));
            assertTrue(sameElements(arr, copy));
        }
    }

    private static Date[] randomDates() {
        Random gen = new Random();
        Date[] arr = new Date[gen.nextInt(100)];
        int i = 0;
        while (i < arr.length) {
            int day = gen.nextInt(31) + 1;
            int month = gen.nextInt(12) + 1;
            int year = gen.nextInt(3000);
            if (Date.validDate(day, month, year)) {
                arr[i] = new Date(day, month, year);
                ++i;
            }
        }
        return arr;
    }

    // Renvoie true ssi arr est ordonné
    private static boolean ordered(Date[] arr) {
        for (int i = 0; i < arr.length - 1; ++i) {
            if (arr[i].compareTo(arr[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }

    // Renvoie la position de la première apparition de d dans arr
    // Renvoie arr.length si pas trouvé
    private static int position(Date d, Date[] arr) {
        int i = 0;
        while (i < arr.length && !d.equals(arr[i]))
            ++i;
        return i;
    }

    // Renvoie true ssi arr1 et arr2 contiennent les mêmes éléments
    // Attention, on "détruit" arr2
    private static boolean sameElements(Date[] arr1, Date[] arr2) {
        if (arr1.length != arr2.length)
            return false;
        for (int i = 0; i < arr1.length; ++i) {
            int pos = position(arr1[i], arr2);
            if (pos == arr2.length) // Pas trouvé -> false
                return false;
            arr2[pos] = null;      // Trouvé -> On l'enlève et on continue...
        }
        return true;
    }

}

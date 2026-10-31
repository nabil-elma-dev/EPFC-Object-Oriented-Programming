package test.java.labo05;

import main.java.labo05.Date;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class DateTreeTest {
    @Test
    public void testAddingDatesAndSorting() {
        Set<Date> ls = new TreeSet<>();

        // adding d1
        Date d1 = new Date(1,5,1998);
        ls.add(d1);
        assertTrue(ls.contains(d1));
        assertEquals(1, ls.size());

        // adding d2
        Date d2 = new Date(18,4,1999);
        ls.add(d2);
        assertTrue(ls.contains(d2));
        assertEquals(2, ls.size());

        // adding d1 once again
        ls.add(d1);
        assertNotEquals(3, ls.size()); // size should be 2 due to incapacity of sets to contain each object more than once

        // exporting collection ls in a LinkedList (p.s.: TreeSet already sorted by itself)
        List<Date> dates = new LinkedList<>();
        for (Date d : ls) {
            dates.add(d);
        } // the last lines can be simplified by writing "List<Date> dates = new LinkedList<>();"

        assertEquals(2, dates.size());
        assertEquals(d1, dates.get(0));
        assertEquals(d2, dates.get(1));
    }
}

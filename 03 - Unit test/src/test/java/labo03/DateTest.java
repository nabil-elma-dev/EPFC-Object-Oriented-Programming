package test.java.labo03;

import static org.junit.Assert.*;


import main.java.labo03.Date;
import main.java.labo03.Program;
import org.junit.Test;

import static org.junit.Assert.*;

public class DateTest {

    @Test
    public void testIncrementSimple() {
        Date d = new Date(1, 1, 2012);
        d.increment();
        assertEquals(2, d.getDay());
        assertEquals(1, d.getMonth());
        assertEquals(2012, d.getYear());
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
    public void testEmptyConstructor() {
        Date d = new Date();
    }

    @Test
    public void testDayOfYear() {
        Date dLeap = new Date(31, 12, 2012);
        Date dLeapFirst = new Date(1, 1, 2012);
        Date dNotLeap = new Date(31, 12, 2013);
        Date dNotLeapFirst = new Date(1, 1, 2013);
        assertEquals(366, dLeap.dayOfYear());
        assertEquals(1, dLeapFirst.dayOfYear());
        assertEquals(365, dNotLeap.dayOfYear());
        assertEquals(1, dNotLeapFirst.dayOfYear());
    }

    @Test
    public void testDayOfWeek() {
        Date nabuntuDayOfBirth = new Date(1,5,1998);
        assertEquals(4, nabuntuDayOfBirth.dayOfWeek()); // day of week should be Friday
        Date timeOfCommit = new Date(12,10,2026);
        assertEquals(0, timeOfCommit.dayOfWeek()); // day of week should be Monday
    }

    @Test
    public void testWrongLeapYear() {
        Date d = new Date(1,1, 2023);
        assertFalse(Date.isLeapYear(d.getYear()));
    }

    @Test
    public void testRightLeapYear() {
        Date d = new Date(1,1, 2024);
        assertTrue(Date.isLeapYear(d.getYear()));
    }

    @Test
    public void testEqualsOnDate() {
        Date d1 = new Date(1,5,1998);
        Date d2 = new Date(1,5,1998);
        assertEquals(d1, d2);
    }

    @Test
    public void testCompareToDate() {
        Date d1 = new Date(1,5,1998);
        Date d1bis = new Date(1,5,1998);
        Date d2 = new Date(18,4,1999);
        assertTrue(d1.compareTo(d2) < 0);
        assertEquals(0, d1.compareTo(d1bis));
        assertFalse(d1bis.compareTo(d2) > 0);
    }

    @Test
    public void testSortingDates() {
        Date[] dates = {
                new Date(22, 10, 1967),
                new Date(1, 5, 1998),
                new Date(10,7,1964),
                new Date(18,4,1999)
        };
        Program.sortArray(dates); // increasing collection (youngest to oldest)
        assertEquals(0, new Date(18, 4, 1999).compareTo(dates[0]));
        assertEquals(0, new Date(1, 5, 1998).compareTo(dates[1]));
        assertEquals(0, new Date(22, 10, 1967).compareTo(dates[2]));
        assertEquals(0, new Date(10, 7, 1964).compareTo(dates[3]));
    }
}

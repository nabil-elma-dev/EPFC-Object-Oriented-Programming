package test.java.labo03;

import static org.junit.Assert.*;


import main.java.labo03.Date;
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
}

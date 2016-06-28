package com.wouter.kata.stringCalc;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Wouter on 28/06/2016.
 */
public class StringCalcTest {

    private StringCalc strCal;

    @Before
    public void init() {
        strCal = new StringCalc();
    }

    @Test
    public void testNumberCount(){
        assertEquals(0, strCal.count(""));
        assertEquals(1, strCal.count("15"));
        assertEquals(2, strCal.count("12,15"));
        assertEquals(5, strCal.count("1,2,3,4,5"));
        assertEquals(2, strCal.count("1\n2"));
        assertEquals(2, strCal.count(";\n1;2"));
    }

    @Test
    public void testSum(){
        assertEquals(0, strCal.add(""));
        assertEquals(1, strCal.add("1"));
        assertEquals(3, strCal.add("1,2"));
        assertEquals(3, strCal.add("1\n2"));
        assertEquals(3, strCal.add(";\n1;2"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegative(){
        assertEquals(0, strCal.add("1,-1"));
    }

    @Test
    public void testIgnoreBig(){
        assertEquals(2, strCal.add("2,1001"));
    }

    @Test
    public void testDelimiters(){
        assertEquals(3, strCal.add(";;;\n1;;;2"));
    }
}
package com.sketchproject;

import static org.junit.Assert.*;

/**
 * Testing
 * Created by Angga on 26/07/2016.
 */
public class MathHelperTest {
    MathHelper math;

    @org.junit.Before
    public void setUp() throws Exception {
        System.out.println("Always call before test each method");
        math = new MathHelper();
    }

    @org.junit.After
    public void tearDown() throws Exception {
        System.out.println("Always call after test each method");
        math = null;
    }

    @org.junit.Test
    public void divideValues() throws Exception {
        assertEquals(2.9, math.divideValues("5", "2"), 0.5);
        assertEquals(15, math.divideValues("150", "10"), 0);
    }

    @org.junit.Test
    public void multiplyValues() throws Exception {
        assertEquals(10, math.multiplyValues("2", "5"), 0);
    }

    @org.junit.Test
    public void subtractValues() throws Exception {
        assertEquals(54, math.subtractValues("80", "26"), 0);
    }

    @org.junit.Test
    public void addValues() throws Exception {
        assertEquals(100, math.addValues("70", "30"), 0);
    }
}
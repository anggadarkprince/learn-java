package com.sketchproject;

/**
 * Static
 * Created by Angga on 25/07/2016.
 */
public class StaticTest {
    private static int numInstances = 0;
    private String name;

    public StaticTest(String name) {
        this.name = name;
        numInstances++;
    }

    public int getNumInstances() {
        return numInstances;
    }

    public static int getNumInstancesX2(){
        return numInstances * 2;
    }

    public String getName() {
        return name;
    }
}

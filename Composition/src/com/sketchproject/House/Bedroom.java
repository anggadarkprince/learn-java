package com.sketchproject.House;

/**
 * Composition
 * Created by Angga on 23/07/2016.
 */
public class Bedroom {
    private String name;
    private Wall wall;
    private Ceiling ceiling;
    private Bed bed;
    private Lamp lamp;

    public Bedroom(String name, Wall wall, Ceiling ceiling, Bed bed, Lamp lamp) {
        this.name = name;
        this.wall = wall;
        this.ceiling = ceiling;
        this.bed = bed;
        this.lamp = lamp;
    }

    public Lamp getLamp() {
        return this.lamp;
    }

    public void makeBed() {
        System.out.println("Bedroom -> Making Bed");
        bed.make();
    }
}

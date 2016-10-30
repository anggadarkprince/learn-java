package com.sketchproject;

/**
 * Composition
 * Created by Angga on 23/07/2016.
 */
public class Monitor {
    private String model;
    private String manufacturer;
    private int size;
    private Resolution nativeResolution;

    public Monitor(String model, String manufacturer, int size, Resolution nativeResolution) {
        this.model = model;
        this.manufacturer = manufacturer;
        this.size = size;
        this.nativeResolution = nativeResolution;
    }

    public void drawPixelArt(int x, int y, String color) {
        System.out.println("Drawing pixel at " + x + ", " + y + " in colour " + color);
    }
}

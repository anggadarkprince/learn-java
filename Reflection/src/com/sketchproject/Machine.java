package com.sketchproject;

/**
 * Reflection
 * Created by Angga on 25/07/2016.
 */
public class Machine extends Matter {
    private String manufacture;
    private int serialNumber;

    public Machine() {
        super("Machine");
        this.manufacture = "No manufacture";
        this.serialNumber = 111;
    }

    public Machine(String manufacture, int serialNumber) {
        super(manufacture + "Machine");
        this.manufacture = manufacture;
        this.serialNumber = serialNumber;
    }

    public void ignite() {
        System.out.println("Ignition the engine");
    }

    public void turnOff() {
        System.out.println("Turning off the engine");
    }

    @Override
    public String toString() {
        return "This machine manufacturer by " + this.manufacture + " with serial number " + this.serialNumber;
    }
}

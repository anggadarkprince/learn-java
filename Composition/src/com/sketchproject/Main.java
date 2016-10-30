package com.sketchproject;

import com.sketchproject.House.*;

public class Main {

    public static void main(String[] args) {
        Dimensions dimensions = new Dimensions(20, 20, 5);
        Case theCase = new Case("220B", "Dell", "240", dimensions);
        Monitor theMonitor = new Monitor("27inch Beast", "Acer", 27, new Resolution(2540, 1440));
        Motherboard theMotherboard = new Motherboard("NJ-342", "Asus", 4, 6, "v2.44");

        PC myPC = new PC(theCase, theMonitor, theMotherboard);
        myPC.powerUp();

        // Create a single room of the house using composition
        // Think about the things that should be included in the room.
        // Maybe physical parts of the house but furniture as well
        // Add at least one method to access an object via a getter and
        // then that objects public method as you saw in the previous video
        // then add at least one method to hide the objects e.g. not using a getter
        // but to access the object ued in the composition within the main class
        // like you saw in this video.

        Wall wall = new Wall("West");
        Ceiling ceiling = new Ceiling(12, 55);
        Bed bed = new Bed("Modern", 4, 3, 2, 1);
        Lamp lamp = new Lamp("Classic", false, 75);

        Bedroom bedroom = new Bedroom("Angga's Room", wall, ceiling, bed, lamp);
        bedroom.makeBed();
        bedroom.getLamp().turnOn();

    }
}

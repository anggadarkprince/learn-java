package com.sketchproject;

public class Main {

    public static void main(String[] args) {
	    // Challenge
        // Start with a base class of a Vehicle, then create a Car class that inherits from this vase class.
        // Finally, create another class, a specific type of Ca that inherits from the Car class.
        // You should be able to hand steering, changing gears, and moving (speed in other words)
        // You will want to decide where to put the appropriate state and behaviours (fields and methods).
        // As mentioned above, changing gears, increasing / decreasing speed should be included.
        // For you specific type of vehicle you will want to add something specific for that type of car.

        Outlander outlander = new Outlander(36);

        System.out.println("- engine start");
        outlander.start();

        System.out.println();
        System.out.println("- accelerating");

        outlander.accelerate(30);

        System.out.println();
        System.out.println("- increase the speed");

        outlander.accelerate(20);

        System.out.println();
        System.out.println("- turn vehicle");

        outlander.steer(45);

        System.out.println();
        System.out.println("- decelerating while turning");

        outlander.accelerate(-42);

        System.out.println();
        System.out.println("- stop the vehicle");

        outlander.stop();
    }
}

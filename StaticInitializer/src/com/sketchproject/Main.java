package com.sketchproject;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        System.out.println("Starting application...");
        ArrayList<Olive> olives = OliveJar.olives;

        // just initializing once
        ArrayList<Olive> olives2 = OliveJar.olives;

        for (Olive o : olives) {
            System.out.println("It's a " + o.toString());
        }

        System.out.println();

        ArrayList<Olive> olivesNonStatic = new OliveJarNonStatic().olives;

        for (Olive o : olivesNonStatic) {
            System.out.println("It's a non static " + o.toString());
        }

        System.out.println();

        ArrayList<Olive> olivesNonStatic2 = new OliveJarNonStatic(5, "Sunrise").olives;

        for (Olive o : olivesNonStatic2) {
            System.out.println("It's a non static " + o.toString());
        }
    }
}

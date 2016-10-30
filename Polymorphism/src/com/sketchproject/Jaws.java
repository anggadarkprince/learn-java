package com.sketchproject;

/**
 * Polymorphism
 * Created by Angga on 23/07/2016.
 */
public class Jaws extends Movie {
    public Jaws(){
        super("Jaws");
    }

    @Override
    public String plot(){
        return "A shark eats lots of people";
    }
}

package com.sketchproject;

/**
 * Polymorphism
 * Created by Angga on 23/07/2016.
 */
public class IndependenceDay extends Movie {
    public IndependenceDay() {
        super("Independence Day");
    }

    @Override
    public String plot() {
        return "Aliens attempt to take over planet earth";
    }
}

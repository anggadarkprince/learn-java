package com.sketchproject;

/**
 * Polymorphism
 * Created by Angga on 23/07/2016.
 */
public class Movie {
    private String name;

    public Movie(String name) {
        this.name = name;
    }

    public String plot() {
        return "No plot here";
    }

    public String getName() {
        return name;
    }
}

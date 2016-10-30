package com.sketchproject;

/**
 * Polymorphism
 * Created by Angga on 23/07/2016.
 */
public class StarWars extends Movie {
    public StarWars() {
        super("Star Wars");
    }

    @Override
    public String plot() {
        return "Imperial forces try to take over the universe";
    }
}

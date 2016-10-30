package com.sketchproject;

/**
 * GenericsChallenge
 * Created by dev on 24/07/2016.
 */
public abstract class Player {
    private String name;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

package com.sketchproject;

/**
 * Final
 * Created by Angga on 25/07/2016.
 */
public class Player {
    public static String PRIMARY_WEAPON = "Sword";
    public static String SECONDARY_WEAPON = "Dagger";
    public final int HIT_POINT = 100;
    private String name;
    private int health;

    public Player(String name) {
        // HIT_POINT = 50; // can't be changed
        this.name = name;
        health = 500;
        System.out.println("Player default health is " + health);
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }
}

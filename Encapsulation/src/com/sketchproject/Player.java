package com.sketchproject;

/**
 * Encapsulation
 * Created by Angga on 23/07/2016.
 */
public class Player {
    public String name;
    public int health;
    public String weapon;

    public void loseHealth(int damage) {
        this.health = this.health - damage;
        if (this.health <= 0) {
            System.out.println("Player knocked out");
        }
    }

    public int healthRemaining() {
        return this.health;
    }
}

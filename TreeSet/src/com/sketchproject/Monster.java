package com.sketchproject;

/**
 * TreeSet
 * Created by Angga on 25/07/2016.
 */
public class Monster implements Comparable<Monster> {
    private String name;
    private String className;
    private int health;

    public Monster(String name, String className) {
        this.name = name;
        this.className = className;
        this.health = 100;
    }

    public String getName() {
        return name;
    }

    public String getClassName() {
        return className;
    }

    public int getHealth() {
        return health;
    }

    @Override
    public int compareTo(Monster monster) {
        return this.name.compareToIgnoreCase(monster.getName());
    }

    @Override
    public String toString() {
        return this.name + " from class " + this.className;
    }
}

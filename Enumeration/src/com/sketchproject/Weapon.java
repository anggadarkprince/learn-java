package com.sketchproject;

/**
 * Enumeration
 * Created by Angga on 25/07/2016.
 */
public enum Weapon {
    SWORD("Sword"), BOW("Bow"), GUN("Gun"), FIST("Fist"), DAGGER("Dagger"), AXE("Axe"), SPEAR("Spear");

    private String nameAsString;

    private Weapon(String nameAsString){
        System.out.println("Init..." + nameAsString);
        this.nameAsString = nameAsString;
    }

    @Override
    public String toString() {
        return this.nameAsString;
    }
}

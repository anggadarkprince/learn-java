package com.sketchproject;

/**
 * OOPMasterChallenge
 * Created by Angga on 23/07/2016.
 */
public class DeluxeBurger extends Hamburger {
    public DeluxeBurger() {
        super("Deluxe", "Sausage & Bacon", 14.54, "White");
        super.addHamburgerAdditional1("Chips", 2.75);
        super.addHamburgerAdditional2("Drink", 1.81);
    }

    @Override
    public void addHamburgerAdditional1(String name, double price) {
        System.out.println("Cannot add additional items to a deluxe burger");
    }

    @Override
    public void addHamburgerAdditional2(String name, double price) {
        System.out.println("Cannot add additional items to a deluxe burger");
    }

    @Override
    public void addHamburgerAdditional3(String name, double price) {
        System.out.println("Cannot add additional items to a deluxe burger");
    }

    @Override
    public void addHamburgerAdditional4(String name, double price) {
        System.out.println("Cannot add additional items to a deluxe burger");
    }
}

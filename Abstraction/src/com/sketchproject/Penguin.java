package com.sketchproject;

/**
 * Abstraction
 * Created by Angga on 24/07/2016.
 */
public class Penguin extends Bird {
    public Penguin(String name) {
        super(name);
    }

    @Override
    public void fly() {
        super.fly();
        System.out.println("I'm not good at that, can I go for a swim instead?");
    }
}

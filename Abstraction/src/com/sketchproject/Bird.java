package com.sketchproject;

/**
 * Abstraction
 * Created by Angga on 24/07/2016.
 */
public abstract class Bird extends Animal implements IFly {
    public Bird(String name) {
        super(name);
    }

    @Override
    public void eat() {
        System.out.println(getName() + " is pecking");
    }

    @Override
    public void breathe() {
        System.out.println("Breathe in, breath out, repeat");
    }

    //public abstract void fly();
    public void fly(){
        System.out.println(getName() + " is flappy");
    }
}

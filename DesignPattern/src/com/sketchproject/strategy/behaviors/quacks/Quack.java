package com.sketchproject.strategy.behaviors.quacks;

import com.sketchproject.strategy.interfaces.QuackBehavior;

public class Quack implements QuackBehavior {
    public void quack() {
        System.out.println("Quack");
    }
}

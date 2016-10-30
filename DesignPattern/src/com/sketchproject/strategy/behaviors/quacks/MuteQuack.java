package com.sketchproject.strategy.behaviors.quacks;

import com.sketchproject.strategy.interfaces.QuackBehavior;

public class MuteQuack implements QuackBehavior {
    public void quack() {
        System.out.println("<< Silence >>");
    }
}

package com.sketchproject.modules;

import com.sketchproject.interfaces.IAnimator;

/**
 * Packages
 * Created by Angga on 25/07/2016.
 */
public class Creature implements IAnimator {

    public Creature() {
        System.out.println(this.getClass().getPackage());
    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }
}

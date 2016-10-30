package com.sketchproject;

/**
 * Interfaces
 * Created by Angga on 24/07/2016.
 */
public class Gearbox {
    private boolean clutchIsIn;

    public void operateClutch(boolean inOrOut) {
        this.clutchIsIn = inOrOut;
    }
}

package com.sketchproject.npc;

import com.sketchproject.modules.Creature;

/**
 * Packages
 * Created by Angga on 25/07/2016.
 */
public class Monster extends Creature {

    public Monster() {
        System.out.println(getClass().getPackage());
    }

    @Override
    public void start() {
        super.start();
    }

    public void attack() {

    }
}

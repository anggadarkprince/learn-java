package com.sketchproject;

import com.sketchproject.modules.Creature;
import com.sketchproject.npc.Monster;
import javafx.scene.Node;

public class Main {

    public static void main(String[] args) {
        // always lower case
        // package names should be unique
        // user your internet domain name, reverse as a prefix for the package name;
	    // oracle specify a convention for the package names at
        // http://docs.oracle.com/javase/specs/jls/se6/html/packages.html#7.7

        Node nodeFX = null;

        javax.xml.soap.Node anotherNode = null;

        org.w3c.dom.Node anotherAnotherNode = null;

        Creature creature = new Creature();

        Creature dragon = new Monster();
    }
}

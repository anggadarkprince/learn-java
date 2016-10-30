package com.sketchproject;

import java.util.Set;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
	    // automatically sort in order by comparable function
        Set<String> set = new TreeSet<>();
        set.add("Banana");
        set.add("Apple");
        set.add("Grape");

        set.forEach(System.out::println);

        Monster orch = new Monster("Liga", "Orch");
        Monster alien = new Monster("Raha", "ET");
        Monster zombie = new Monster("Mara", "Zombie");

        Set<Monster> monsterSet = new TreeSet<>();
        monsterSet.add(orch);
        monsterSet.add(alien);
        monsterSet.add(zombie);

        monsterSet.forEach(System.out::println);
    }
}

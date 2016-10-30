package com.sketchproject;

import java.util.ArrayList;

public class OliveJarNonStatic {

    public ArrayList<Olive> olives;

    // called before constructor, shared for overloading constructor
    {
        System.out.println("non static initializing...");
        olives = new ArrayList<>();
        olives.add(new Olive("Kalamata", 0x000000));
        olives.add(new Olive("Picholine", 0x00FF00));
        olives.add(new Olive("Kalamata", 0x000000));
    }

    public OliveJarNonStatic() {
        System.out.println("Constructor non static");
    }

    public OliveJarNonStatic(int nOlives, String oliveName) {
		for(int i = 0; i <= nOlives; i++){
            olives.add(new Olive(oliveName, 0x000000));
        }
    }

}

package com.sketchproject.strategy.behaviors.quacks;

import com.sketchproject.strategy.interfaces.QuackBehavior;

public class Squeak implements QuackBehavior {
	public void quack() {
		System.out.println("Squeak");
	}
}

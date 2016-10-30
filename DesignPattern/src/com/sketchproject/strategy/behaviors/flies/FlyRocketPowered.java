package com.sketchproject.strategy.behaviors.flies;

import com.sketchproject.strategy.interfaces.FlyBehavior;

public class FlyRocketPowered implements FlyBehavior {
	public void fly() {
		System.out.println("I'm flying with a rocket");
	}
}

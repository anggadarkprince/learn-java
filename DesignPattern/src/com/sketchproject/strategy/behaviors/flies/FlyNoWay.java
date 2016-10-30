package com.sketchproject.strategy.behaviors.flies;

import com.sketchproject.strategy.interfaces.FlyBehavior;

public class FlyNoWay implements FlyBehavior {
	public void fly() {
		System.out.println("I can't fly");
	}
}

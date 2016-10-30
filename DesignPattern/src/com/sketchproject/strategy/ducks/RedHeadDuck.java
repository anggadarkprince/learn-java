package com.sketchproject.strategy.ducks;

import com.sketchproject.strategy.behaviors.flies.FlyWithWings;
import com.sketchproject.strategy.behaviors.quacks.Quack;

public class RedHeadDuck extends Duck {
 
	public RedHeadDuck() {
		flyBehavior = new FlyWithWings();
		quackBehavior = new Quack();
	}
 
	public void display() {
		System.out.println("I'm a real Red Headed duck");
	}
}

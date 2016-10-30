package com.sketchproject.strategy.ducks;

import com.sketchproject.strategy.behaviors.flies.FlyWithWings;
import com.sketchproject.strategy.behaviors.quacks.Quack;

public class MallardDuck extends Duck {

	public MallardDuck() {
		quackBehavior = new Quack();
		flyBehavior = new FlyWithWings();
	}

	public void display() {
		System.out.println("I'm a real Mallard duck");
	}
}

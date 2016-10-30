package com.sketchproject.strategy.ducks;

import com.sketchproject.strategy.behaviors.flies.FlyNoWay;
import com.sketchproject.strategy.behaviors.quacks.Squeak;

public class RubberDuck extends Duck {
 
	public RubberDuck() {
		flyBehavior = new FlyNoWay();
		quackBehavior = new Squeak();
	}
 
	public void display() {
		System.out.println("I'm a rubber duckie");
	}
}

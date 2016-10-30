package com.sketchproject.strategy.ducks;

import com.sketchproject.strategy.behaviors.flies.FlyNoWay;
import com.sketchproject.strategy.behaviors.quacks.Quack;

public class ModelDuck extends Duck {

	public ModelDuck() {
		flyBehavior = new FlyNoWay();
		quackBehavior = new Quack();
	}

	public void display() {
		System.out.println("I'm a model duck");
	}
}

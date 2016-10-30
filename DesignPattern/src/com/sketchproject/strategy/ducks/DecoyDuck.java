package com.sketchproject.strategy.ducks;

import com.sketchproject.strategy.behaviors.flies.FlyNoWay;
import com.sketchproject.strategy.behaviors.quacks.MuteQuack;

public class DecoyDuck extends Duck {

	public DecoyDuck() {
		setFlyBehavior(new FlyNoWay());
		setQuackBehavior(new MuteQuack());
	}

	public void display() {
		System.out.println("I'm a duck Decoy");
	}
}

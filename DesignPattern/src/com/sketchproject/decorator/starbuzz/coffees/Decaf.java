package com.sketchproject.decorator.starbuzz.coffees;

import com.sketchproject.decorator.starbuzz.component.Beverage;

public class Decaf extends Beverage {

	public Decaf() {
		description = "Decaf Coffee";
	}
 
	public double cost() {
		return 1.05;
	}
}


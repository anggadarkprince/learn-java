package com.sketchproject.decorator.starbuzz.coffees;

import com.sketchproject.decorator.starbuzz.component.Beverage;

public class Espresso extends Beverage {
  
	public Espresso() {
		description = "Espresso";
	}
  
	public double cost() {
		return 1.99;
	}
}


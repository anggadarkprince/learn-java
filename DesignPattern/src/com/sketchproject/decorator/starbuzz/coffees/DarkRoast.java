package com.sketchproject.decorator.starbuzz.coffees;

import com.sketchproject.decorator.starbuzz.component.Beverage;

public class DarkRoast extends Beverage {

	public DarkRoast() {
		description = "Dark Roast Coffee";
	}
 
	public double cost() {
		return .99;
	}
}


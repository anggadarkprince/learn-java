package com.sketchproject.decorator.starbuzz.coffees;

import com.sketchproject.decorator.starbuzz.component.Beverage;

public class HouseBlend extends Beverage {

	public HouseBlend() {
		description = "House Blend Coffee";
	}
 
	public double cost() {
		return .89;
	}
}


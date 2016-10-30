package com.sketchproject.decorator.starbuzz.condiments;

import com.sketchproject.decorator.starbuzz.component.Beverage;
import com.sketchproject.decorator.starbuzz.decorator.CondimentDecorator;

public class Whip extends CondimentDecorator {
	Beverage beverage;
 
	public Whip(Beverage beverage) {
		this.beverage = beverage;
	}
 
	public String getDescription() {
		return beverage.getDescription() + ", Whip";
	}
 
	public double cost() {
		return .10 + beverage.cost();
	}
}

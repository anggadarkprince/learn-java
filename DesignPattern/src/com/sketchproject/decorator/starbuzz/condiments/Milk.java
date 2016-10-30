package com.sketchproject.decorator.starbuzz.condiments;

import com.sketchproject.decorator.starbuzz.component.Beverage;
import com.sketchproject.decorator.starbuzz.decorator.CondimentDecorator;

public class Milk extends CondimentDecorator {
	Beverage beverage;

	public Milk(Beverage beverage) {
		this.beverage = beverage;
	}

	public String getDescription() {
		return beverage.getDescription() + ", Milk";
	}

	public double cost() {
		return .10 + beverage.cost();
	}
}

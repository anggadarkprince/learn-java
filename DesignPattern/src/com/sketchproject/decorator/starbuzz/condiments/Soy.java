package com.sketchproject.decorator.starbuzz.condiments;

import com.sketchproject.decorator.starbuzz.component.Beverage;
import com.sketchproject.decorator.starbuzz.decorator.CondimentDecorator;

public class Soy extends CondimentDecorator {
	Beverage beverage;

	public Soy(Beverage beverage) {
		this.beverage = beverage;
	}

	public String getDescription() {
		return beverage.getDescription() + ", Soy";
	}

	public double cost() {
		return .15 + beverage.cost();
	}
}

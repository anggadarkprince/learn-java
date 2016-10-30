package com.sketchproject.decorator.starbuzz;

import com.sketchproject.decorator.starbuzz.coffees.Espresso;
import com.sketchproject.decorator.starbuzz.coffees.HouseBlend;
import com.sketchproject.decorator.starbuzz.component.Beverage;
import com.sketchproject.decorator.starbuzz.condiments.Mocha;
import com.sketchproject.decorator.starbuzz.condiments.Soy;

public class StarbuzzCoffee {
 
	public static void main(String args[]) {
		Beverage beverage = new Espresso();
		System.out.println(beverage.getDescription() + " $" + beverage.cost());

		Beverage beverage2 = new HouseBlend();
		beverage2 = new Soy(beverage2);
		beverage2 = new Mocha(beverage2);
		System.out.println(beverage2.getDescription() + " $" + beverage2.cost());

		Beverage houseBlend = new HouseBlend();
		Beverage decorations = new Mocha(new Soy(houseBlend));
		System.out.println(decorations.getDescription() + " $" + decorations.cost());

		Beverage houseBlend2 = new HouseBlend();
		Beverage decorations2 = new Soy(new Mocha(houseBlend2));
		System.out.println(decorations2.getDescription() + " $" + decorations2.cost());
	}
}

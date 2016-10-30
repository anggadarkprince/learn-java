package com.sketchproject.factory.pizzafm.stores;

import com.sketchproject.factory.pizzafm.pizzas.*;

public class NYPizzaStore extends PizzaStore {

	public Pizza createPizza(String item) {
		switch (item) {
			case "cheese":
				return new NYStyleCheesePizza();
			case "veggie":
				return new NYStyleVeggiePizza();
			case "clam":
				return new NYStyleClamPizza();
			case "pepperoni":
				return new NYStylePepperoniPizza();
			default:
				return null;
		}
	}
}

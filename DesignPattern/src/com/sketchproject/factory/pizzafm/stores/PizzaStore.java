package com.sketchproject.factory.pizzafm.stores;

import com.sketchproject.factory.pizzafm.pizzas.Pizza;

public abstract class PizzaStore {
 
	public abstract Pizza createPizza(String item);
 
	public Pizza orderPizza(String type) {
		Pizza pizza = createPizza(type);
		System.out.println("--- Making a " + pizza.getName() + " ---");
		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();
		return pizza;
	}
}

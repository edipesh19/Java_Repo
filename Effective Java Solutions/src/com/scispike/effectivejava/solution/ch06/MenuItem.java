package com.scispike.effectivejava.solution.ch06;

import java.util.HashMap;

public class MenuItem {
	private String name;
	private double price;
	private static HashMap<String, MenuItem> menuItems = new HashMap<String, MenuItem>();
	private static HashMap<String, Double> itemPrice = new HashMap<String, Double>();
	
	static {
		itemPrice.put("Cappuccino", 4.99);
		itemPrice.put("CoffeeOfTheDay", 2.99);
		itemPrice.put("Frappe", 3.99);
		itemPrice.put("Xpresso", 3.99);
	}
	
	private MenuItem(String name, double price) {
		this.name = name;
		this.price = price;
	}
	
	public static MenuItem getMenuItem(String name) {
		if (name == null || name.trim().length() == 0) {
			throw new IllegalArgumentException("MenuItem:getMenuItem::Name can't be null or empty");
		}
		
		MenuItem rslt = menuItems.get(name);
		if (rslt == null) {
			rslt = new MenuItem(name, itemPrice.get(name));
			menuItems.put(name, rslt);
		}
		return rslt;
	}
	
	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}
	
	@Override
	public String toString() {
		return String.format("[%s %.2f]", this.name, this.price);
	}
}

package com.scispike.effectivejava.solution.ch06;

public class OrderItem {
	private MenuItem item;
	private int quantity;
	
	public OrderItem(MenuItem item, int quantity) {
		this.item = item;
		this.quantity = quantity;
	}

	public MenuItem getItem() {
		return item;
	}

	public void setItem(MenuItem item) {
		this.item = item;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public String toString() {
		return String.format("[%d %s]", this.quantity, this.item);
	}
}

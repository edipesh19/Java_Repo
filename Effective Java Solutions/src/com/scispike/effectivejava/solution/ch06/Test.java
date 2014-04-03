package com.scispike.effectivejava.solution.ch06;

public class Test {

	public static void main(String[] args) {
		Order order = new Order("John");
		Table t = Table.getTable(1);
		order.setTable(t);
		MenuItem item1 = MenuItem.getMenuItem("Cappuccino");
		OrderItem orderItem = new OrderItem(item1, 2);
		order.addOrder(orderItem);
		MenuItem item2 = MenuItem.getMenuItem("Xpresso");
		orderItem = new OrderItem(item2, 1);
		order.addOrder(orderItem);
		System.out.println(order);
		System.out.printf("Total price: %.2f", order.getTotalPrice());
	}

}

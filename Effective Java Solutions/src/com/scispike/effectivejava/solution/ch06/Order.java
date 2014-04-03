package com.scispike.effectivejava.solution.ch06;

import java.util.ArrayList;
import java.util.List;

public class Order {
	private String customerName;
	private List<OrderItem> orderItems;
	private Table table;
	
	public Order(String customerName) {
		this.customerName = customerName;
		this.orderItems = new ArrayList<OrderItem>();
	}
	
	public Order(String customerName, List<OrderItem> items, Table table) {
		this.customerName = customerName;
		this.orderItems = items;
		this.table = table;
	}
		
	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		if (customerName == null || customerName.trim().length() == 0) {
			throw new IllegalArgumentException("Order:setCustomerName::Customer Name can't be null or empty");
		}
		this.customerName = customerName;
	}

	public List<OrderItem> getItems() {
		return orderItems;
	}
	
	public void changeOrder(List<OrderItem> items) {
		this.orderItems = items;
	}
	
	public Table getTable() {
		return table;
	}

	public void setTable(Table table) {
		this.table = table;
	}	

	public void addOrder(OrderItem oi) {
		if (oi == null || oi.getItem() == null || oi.getQuantity() <= 0) {
			throw new IllegalArgumentException("Order:addOrder::Order item must have valid quantity and item");
		}
		this.orderItems.add(oi);
	}
	
	public double getTotalPrice() {
		double rslt = 0.0;
		
		for (OrderItem o : this.orderItems) {
			rslt += o.getQuantity() * o.getItem().getPrice();
		}
		
		return rslt;
	}
	
	@Override
	public String toString() {
		return String.format("[%s %s: %s]", this.customerName, this.table, this.orderItems);
	}
}

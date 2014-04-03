package com.factory;

import javax.xml.parsers.DocumentBuilderFactory;

public class Customer {
	
	
	private Customer(){
		DocumentBuilderFactory fact = DocumentBuilderFactory.newInstance();
		System.out.println(fact);
	}
	
	public static Customer getInstance(){
		
		return new Customer();
	}
	public static void main(String[] args) {
		Customer cus = Customer.getInstance();
	}

}

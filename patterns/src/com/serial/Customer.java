package com.serial;

import java.io.Serializable;

public class Customer implements Serializable{
	
	String name;
	int id;
	double sal;
	
	public Customer(String name,int id,double sal){
		this.name = name;
		this.id = id;
		this.sal = sal;
	}
	
	
	public Customer(){
		
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public double getSal() {
		return sal;
	}



	public void setSal(double sal) {
		this.sal = sal;
	}
	
	
	
	

}

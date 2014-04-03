package com.testing;


public class Customer {

	int id;
	String name;
	double sal;
	
	public Customer(){
		
	}
	public Customer(int id){
		this.id = id;
	}

	@ppAnno(id=20,name="sathish")
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	private void setName(String name) {
		System.out.println("*************** set name called ..."+name);
		this.name = name;
	}

	public double getSal() {
		return sal;
	}

	public void setSal(double sal) {
		this.sal = sal;
	}
	
}

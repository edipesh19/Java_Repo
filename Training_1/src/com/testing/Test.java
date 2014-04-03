package com.testing;

public class Test implements Cloneable{
	
	Merchant mer;
	Customer cus;
	
	
	
	
	public Test(){
		
	}

	public Merchant getMer() {
		return mer;
	}

	public void setMer(Merchant mer) {
		this.mer = mer;
	}

	public Customer getCus() {
		return cus;
	}

	public void setCus(Customer cus) {
		this.cus = cus;
	}

	
	/*public Test clone() throws CloneNotSupportedException {
		return (Test)super.clone();
	}*/
	
	public static void main(String[] args) {
		try {
			Test t = new Test();
			Merchant mer = new Merchant();
			Customer cus = new Customer();
			t.setCus(cus);
			t.setMer(mer);
			Test cloneTwo = (Test)t.clone();
			
			
			//Test clonedObj = t.clone();
			System.out.println(t.getCus());
			System.out.println(cloneTwo.getCus());
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}




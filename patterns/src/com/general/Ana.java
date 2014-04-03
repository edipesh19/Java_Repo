package com.general;

public class Ana {

	Travel t = new Travel() {
		
		@Override
		public int getSpeed() {
			return 100;
		}
	};
	
	public int getS(){
		return 100;
	}
	
	Ana a = new Ana(){
		
		public int getS() {
			return 400;
		}
	};
	
	
	public Ana(){
		t.getSpeed();
	}
}

interface Travel{
	public int getSpeed();
}

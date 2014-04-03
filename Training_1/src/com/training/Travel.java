package com.training;

public interface Travel {

	public int speed();
	public int getName();
	public static class DefaultTravelImpl{
		
		public int speed(){
			return 300;
		}
	}
	
}

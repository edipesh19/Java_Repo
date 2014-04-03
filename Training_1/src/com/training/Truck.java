package com.training;

public class Truck implements Travel {

	@Override
	public int speed() {
		DefaultTravelImpl impl = new DefaultTravelImpl();
		return impl.speed();
	}

	@Override
	public int getName() {
		// TODO Auto-generated method stub
		return 0;
	}

}

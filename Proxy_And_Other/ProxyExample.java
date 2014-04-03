package com.proxy;

import java.lang.reflect.Proxy;

public class ProxyExample {

	public static void main(String[] args) {
		//ProxyExample pe = new ProxyExample();
		Animal lion = new Lion();
		Animal dog = new Dog();
		
		Animal proxy = (Animal) Proxy.newProxyInstance(lion.getClass()
				.getClassLoader(), lion.getClass().getInterfaces(),
				new AnimalInvocationHandler(lion,dog,"doug"));
		proxy.getSound();
		System.out.println(proxy.getClass().getName());
		
		/*Travel t = new ExampleTravel();
		Travel travelProxy = (Travel) Proxy.newProxyInstance(t.getClass()
				.getClassLoader(), t.getClass().getInterfaces(),
				new TravelInvocationHandler());
		System.out.println(travelProxy);
		travelProxy.getSpeed(); */
	//	travelProxy.setSpeed(100);
		
		
	}
}

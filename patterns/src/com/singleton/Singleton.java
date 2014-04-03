package com.singleton;

public class Singleton {
	// eager loading of object
	private static Singleton singleInstance = new Singleton();

	private Singleton() {
	}

	public static Singleton getSingleInstance() {
		if(singleInstance == null){
			singleInstance = new Singleton();
		}
		return singleInstance;
	}
}

class SingletonLazy {
	// lazy loading 
	private static SingletonLazy singleInstance;
	

	private SingletonLazy() {
	}

	public static SingletonLazy getSingleInstance() {
		if (singleInstance == null) {
			synchronized (SingletonLazy.class) {
				if (singleInstance == null) {
					singleInstance = new SingletonLazy();
				}
			}
		}
		return singleInstance;
	}
	public static void main(String[] args) {
		SingletonLazy lazy = SingletonLazy.getSingleInstance();
		
	}
}

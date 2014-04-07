package org.pattern.singleton;

class Singleton{
	private static Singleton singleton = new Singleton();
	
	private Singleton(){
	}
	
	public static Singleton getInstance(){
		return singleton;
	}
	
	public void message(){
		System.out.println("Invoked function using singleton object");
	}
}
	
public class SingletonDemoStatic {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Singleton obj = Singleton.getInstance();
		obj.message();

	}

}

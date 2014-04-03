package com.testing;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ppAnno {
	
	int id();
	String name(); 

	public static class Test{
		int id;
		String name;
		
		public Test(){
			
		}
		
		public void getC(){
			System.out.println("getC is called ..");
		}
	}
}

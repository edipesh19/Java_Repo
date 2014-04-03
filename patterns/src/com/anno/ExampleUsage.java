package com.anno;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import javax.annotation.PreDestroy;
@DefaultPP(id=15,val="This is  used")
public class ExampleUsage {
	
	
	public ExampleUsage(){
		
	}
	
	@DefaultPP(id=12,val="This is not used")
	//@log(msg="",logmetname="")
	public void getC(){
		
	}
	@PreDestroy
	public void des(){
		
	}
	
	@DefaultPP(id=15,val="This is  used")
	public void getD(){
		
	}
	@DefaultPP(id=15,val="This is  used")
	public static void main(String[] args) {
		try {
			//ExampleUsage use = new ExampleUsage();
			
			Class cls = Class.forName("com.anno.ExampleUsage");
			
			Method met[] = cls.getDeclaredMethods();
			for (int i = 0; i < met.length; i++) {
			//	System.out.println(met[i]);
				if(met[i].getName().indexOf("getC") != -1){
					Annotation anno[] = met[i].getAnnotations();
					//System.out.println(anno[i].getClass().getName());
					for (int j = 0; j < anno.length; j++) {
						System.out.println(anno[j]);
						if(anno[j] instanceof DefaultPP){
							DefaultPP annopp = (DefaultPP)anno[j];
							System.out.println(annopp.id());
							System.out.println(annopp.val());
						}
						
					}
				}
			}
			
			
			
			
			
			
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

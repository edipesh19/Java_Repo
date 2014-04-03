package com.testing;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Refl {
	
	public static void main(String[] args) {
		try {
			Class cls = Class.forName("com.testing.Customer");
			Object obj = cls.newInstance();
			Field f[] = cls.getDeclaredFields();
			for (int i = 0; i < f.length; i++) {
				System.out.println(f[i]);
			}
			Constructor cons[] = cls.getDeclaredConstructors();
			for (int i = 0; i < cons.length; i++) {
				System.out.println(cons[i]);
			}
			Method met[] = cls.getDeclaredMethods();
			for (int i = 0; i < met.length; i++) {
				//System.out.println(met[i]);
				if(met[i].getName().indexOf("setName") != -1){
					met[i].setAccessible(true);
					met[i].invoke(obj, new Object[]{"reflectiontesting"});
				}
				if(met[i].getName().indexOf("getId") != -1){
				Annotation anno[] = met[i].getAnnotations();
				for (int j = 0; j < anno.length; j++) {
					System.out.println(anno[j]);
					if(anno[j] instanceof ppAnno){
						ppAnno pp = (ppAnno)anno[j];
						ppAnno.Test  t = new ppAnno.Test();
						System.out.println(pp.id());
						System.out.println(pp.name());
					}
				}
			}
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

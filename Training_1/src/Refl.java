

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.testing.ppAnno;

public class Refl {
	
	public static void main(String[] args) {
		try {
			
			Class cls = Class.forName("com.pacone.Customer");
			//Object obj = cls.newInstance();
			Constructor cons[] = cls.getDeclaredConstructors();
			for (int i = 0; i < cons.length; i++) {
				System.out.println("cons == "+cons[i]);
			}
			Method met[] = cls.getDeclaredMethods();
			for (int i = 0; i < met.length; i++) {
				System.out.println("Methods == "+met[i]);
				if(met[i].getName().indexOf("getCustomer") != -1){
					//met[i].invoke(obj, new Object[]{});
					Annotation anno[] = met[i].getAnnotations();
					for (int j = 0; j < anno.length; j++) {
						System.out.println(anno[j]);
						if(anno[j] instanceof ppAnno){
							ppAnno pp = (ppAnno)anno[j];
							System.out.println(pp.id());
							System.out.println(pp.name());
						}
					}
				}
			}
			Field field[] = cls.getDeclaredFields();
			for (int i = 0; i < field.length; i++) {
				System.out.println(field[i]);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

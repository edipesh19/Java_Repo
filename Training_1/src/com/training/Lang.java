package com.training;

import java.io.IOException;

public class Lang {
	int id = 10;
	String name = "";
	double d = 0.0;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getD() {
		return d;
	}

	public void setD(double d) {
		this.d = d;
	}

	@Override
	public int hashCode() {
		return 20 * id + 400;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj != null){
			if(obj instanceof Lang){
				Lang lang = (Lang)obj;
				if(lang.getId() == this.getId()){
					return true;
				}
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "Lang [id=" + id + ", name=" + name + ", d=" + d + "]";
	}



	public static void main(String[] args) {
		
		Runtime r = Runtime.getRuntime();
		r.addShutdownHook(new Thread(){
			
			@Override
			public void run() {
				System.out.println("Virtual machine is going to shutdown !!!!!!");
			}
			
		});
		Lang lan = new Lang();
		Lang lan1 = new Lang();
		lan.setId(100);
		lan1.setId(100);
		Class cls = lan.getClass();
		
		System.out.println(lan.hashCode());
		System.out.println(lan1.hashCode());
		
		//System.exit(1);
		
		int k = 0;
		long start = System.currentTimeMillis();
		for(int i= 0 ;i < 332453232;i++){
			k = k+i;
		}
		long end = System.currentTimeMillis();
		
		int one[] = {3,52,3,4,32,4,2,234,2,3,2,3};
		int two[] = new int[one.length];
		System.arraycopy(one, 0, two, 0, one.length);
		
		System.out.println(end-start);
		System.out.println("k == "+k);
		if(lan.equals(lan1)){
			System.out.println("equals ..");
		}else{
			System.out.println("not equals ..");
		}
		
		
		
		
	
		try {
			r.exec("notepad");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//System.out.println(lan);
	}

}














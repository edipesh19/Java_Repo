package com.proxy;

import java.lang.reflect.Proxy;

public class Calculator implements Calc {

	@Override
	public int add(int i, int j) {
		System.out.println("inside the method add ()");
		return i+j;
	}

	@Override
	public int sub(int i, int j) {
		
		return i-j;
	}
	
	public static void main(String[] args) {
		try {
			Calc cal = new Calculator();
			int res = cal.add(100, 100);
			System.out.println(res);
			
			
			Calc proxy = (Calc) Proxy.newProxyInstance(cal.getClass()
					.getClassLoader(), cal.getClass().getInterfaces(),
					new CalcInvocationHandler(cal));
			int res1 = proxy.add(100,200);
			System.out.println(res1);
		} catch (Exception e) {
			
		}
	}

}

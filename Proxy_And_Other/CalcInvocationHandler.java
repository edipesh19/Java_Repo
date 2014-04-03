package com.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class CalcInvocationHandler implements InvocationHandler {
	private Object realSubject = null;
	
	public CalcInvocationHandler(Object realSubject) {
		this.realSubject = realSubject;
	}

	public Object invoke(Object proxy, Method m, Object[] args) {
		Object result = null;
		Integer res = null;
		System.out.println("Before calling "+m.getName());
			try {
				result = m.invoke(realSubject, args);
				if(result instanceof Integer){
					res = (Integer)result;
					res = res + 10;
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			System.out.println("After calling "+m.getName());
		return res;
	}

	
}
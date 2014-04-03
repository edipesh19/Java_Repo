package com.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class AnimalInvocationHandler implements InvocationHandler {
	private Object dog;
	private String type;

	public AnimalInvocationHandler(Object realSubject,Object dog,String type) {
		this.realSubject = realSubject;
		this.dog = dog;
		this.type = type;
	}

	public Object invoke(Object proxy, Method m, Object[] args) {
		Object result = null;
		if(type.equals("dog")){
			try {
				result = m.invoke(dog, args);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}else{
			try {
				result = m.invoke(realSubject, args);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return result;
	}

	private Object realSubject = null;
}
package com.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TravelInvocationHandler implements InvocationHandler {

	@Override
	public Object invoke(Object arg0, Method met, Object[] arg2)
			throws Throwable {
		if(met.getName().indexOf("getSpeed") != -1){
			System.out.println("getspeed");
			return 2000;
		}else if(met.getName().indexOf("setSpeed") != -1){
			int args = (Integer)arg2[0];
			System.out.println("inside setSpeed call "+args);
		}
		return null;
	}

}

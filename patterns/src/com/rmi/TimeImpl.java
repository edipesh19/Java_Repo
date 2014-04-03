package com.rmi;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;

public class TimeImpl extends UnicastRemoteObject 
		implements Time {
	
	public TimeImpl() throws Exception{
		
	}
	public Date getDate() {
		System.out.println("get Date called ");
		return new Date();
	}
	public static void main(String[] args) {
		try {
			LocateRegistry.createRegistry(1099);
			Naming.rebind("test",new TimeImpl());
			System.out.println(" I am registered ..");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

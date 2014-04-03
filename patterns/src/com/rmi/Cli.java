package com.rmi;

import java.rmi.Naming;
import java.util.Date;

public class Cli {
	
	public static void main(String[] args) {
		try {
			Time t = (Time)Naming.lookup("rmi://localhost/test");
			System.out.println(t.getClass().getName());
			Date d = t.getDate();
			System.out.println(d);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

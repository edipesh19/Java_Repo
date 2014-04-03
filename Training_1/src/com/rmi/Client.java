package com.rmi;

import java.rmi.Naming;
import java.util.ArrayList;

public class Client {

	public static void main(String[] args) {
		try {
			RemInter rem = (RemInter)Naming.lookup("rmi://localhost/ser");
			ArrayList<String> ar = new ArrayList<String>();
			ar.add("oneeeeeee");
			ar.add("twooooooo");
			System.out.println(rem.getName(ar));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

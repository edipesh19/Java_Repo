package com.rmi;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class RemoteImpl extends UnicastRemoteObject implements RemInter{

	
	public RemoteImpl() throws RemoteException{
		super();
	}
	@Override
	public String getName(ArrayList<String> list) throws RemoteException {
		System.out.println(list);
		return list.get(0);
	}
	public static void main(String[] args) {
		try {
			Registry registry = LocateRegistry.createRegistry(1099);
			Naming.rebind("ser", new RemoteImpl());
			System.out.println("rmi server am ready");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}

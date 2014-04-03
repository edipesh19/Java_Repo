package com.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface RemInter extends Remote{
	
	public String getName(ArrayList<String> list) throws RemoteException;

}

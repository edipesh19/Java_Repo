package com.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;

public interface Time extends Remote{

	public Date getDate() throws RemoteException;
}

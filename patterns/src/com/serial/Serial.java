package com.serial;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serial {
	
	public void doSer(){
		ObjectOutputStream oos = null;
		
		try {
			Customer cus = new Customer("raja",12,1222.34);
			oos = new ObjectOutputStream(new FileOutputStream("c:\\gaj\\test.ser"));
			oos.writeObject(cus);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if(oos != null)
					oos.close();
			} catch (Exception e2) {
				
			}
		}
	}
	public void doDeSer(){
		ObjectInputStream ois = null;
		try {
			//Customer cus = new Customer("raja",12,1222.34);
			ois = new ObjectInputStream(new FileInputStream("c:\\gaj\\test.ser"));
			Customer cus = (Customer)ois.readObject();
			System.out.println("Cus id == "+cus.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if(ois != null)
					ois.close();
			} catch (Exception e2) {
				
			}
		}
	}
	
	public static void main(String[] args) {
	    Serial ser = new Serial();
	    ser.doSer();
	    ser.doDeSer();
	}

}

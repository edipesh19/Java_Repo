package com.io;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class Ser {
	public static void main(String[] args) {
		Ser s = new Ser();
		s.doSer();
		s.doDeSer();
	}
	
	public void doSer(){
		ObjectOutputStream oos = null;
		try {
			Customer cus = new Customer();
			cus.setId(10);
			cus.setName("sss");
			oos = new ObjectOutputStream(new FileOutputStream("C:\\gaj\\test.ser"));
			oos.writeObject(cus);
			oos.flush();
	
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if(oos != null)
					oos.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}
	
	public void doDeSer(){
		ObjectInputStream ois = null;
		try {
			
			ois = new ObjectInputStream(
					new FileInputStream("C:\\gaj\\test.ser"));
			Customer cus = (Customer)ois.readObject();
			System.out.println(cus.getId());
			System.out.println(cus.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if(ois != null)
					ois.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}

}

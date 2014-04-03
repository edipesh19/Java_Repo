package com.testing;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class Excep {
	
	public Excep(){
		 FileInputStream fis = null;
		  try {
			callCustomer(200);
			URL u = new URL("http://java.sun.com");
			URLConnection c = u.openConnection();
			return;
		}catch(IOException e1){
			e1.printStackTrace();
		}catch(Exception e1){
			e1.printStackTrace();
		}finally{
			System.out.println("Finally is called ");
			if(fis != null)
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
	
	public void callCustomer(int i) throws PPException{
		if(i == 200){
			throw new PPException("i cannot be equal to 200");
		}
	}
	
	public static void main(String[] args) {
		Excep e = new Excep();
	}

}

class PPException extends Exception{
	
	public PPException(String msg){
		super(msg);
	}
	
	
}













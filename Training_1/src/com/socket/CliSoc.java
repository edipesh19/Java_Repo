package com.socket;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class CliSoc {
	
	
	public CliSoc(){
	
		Socket soc = null;
		InputStream is = null;
		OutputStream os = null;
		try {
			soc = new Socket("localhost",10000);
		/*	os = soc.getOutputStream();
			os.write(new String("This is example...").getBytes());
			os.flush();*/
			is = soc.getInputStream();
			int i = 0;
			while( (i = is.read()) != -1){
				System.out.print((char)i);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try{
				if(soc != null)
					soc.close();
				if(is != null)
					is.close();
				if(os != null)
					os.close();
				
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		CliSoc ser = new CliSoc();
	}

}

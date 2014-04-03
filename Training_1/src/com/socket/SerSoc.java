package com.socket;

import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SerSoc {
	
	
	public SerSoc(){
	
		ServerSocket ser = null;
		Socket soc = null;
		OutputStream os = null;
		try {
			ser = new ServerSocket(10000);
			soc = ser.accept();
			os = soc.getOutputStream();
			os.write("This is from sever".getBytes());
			os.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try{
				if(soc != null)
					soc.close();
				if(ser != null)
					ser.close();
				if(os != null)
					os.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		SerSoc ser = new SerSoc();
	}

}

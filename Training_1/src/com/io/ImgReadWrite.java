package com.io;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ImgReadWrite {
	byte b[] = null;
	public static void main(String[] args) {
		ImgReadWrite read = new ImgReadWrite();
		read.readImg("c:\\faces.jpg");
		read.writeImg("c:\\faces1.jpg");
	}

	private void writeImg(String path) {
		
		DataOutputStream dos = null;
		try {
			dos = new DataOutputStream(new FileOutputStream(path));
			dos.write(b);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if(dos != null)
					dos.close();
			} catch (Exception e2) {
				
			}
		}
		
	}

	private void readImg(String path) {
		DataInputStream dis = null;
		try {
			dis = new DataInputStream(new FileInputStream(path));
			int size = dis.available();
			b = new byte[size];
			dis.read(b);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if(dis != null)
					dis.close();
			} catch (Exception e2) {
				
			}
		}
	}
	
	
	

}

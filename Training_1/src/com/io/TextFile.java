package com.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class TextFile {
	
	public String readFile(){
		BufferedReader br = null;
		StringBuilder sb = null;
		try {
			br = new BufferedReader(
					new FileReader("C:\\Users\\gajg\\workspace\\javatraining\\src\\com\\io\\TextFile.java"));
			String tmp = "";
			sb = new StringBuilder();
			while((tmp = br.readLine()) != null){
				sb.append(tmp);
				sb.append("\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if(br != null)
					br.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return sb.toString();
	}
	
	public void writeFile(){
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(
					new FileWriter("C:\\Users\\gajg\\test.txt"));
			String tmp = "This is example";
			bw.write(tmp);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if(bw != null)
					bw.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}

	public static void main(String[] args) {
		TextFile tf = new TextFile();
		System.out.println(tf.readFile());
		tf.writeFile();
	}
}








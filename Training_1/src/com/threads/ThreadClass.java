package com.threads;

public class ThreadClass extends Thread{
	
	int j = 100;
	
	public ThreadClass(String name){
		setName(name);
		start();
	}
	//@Override
	public void run(){
		for(int i=0;i<10;i++){
			System.out.println(" Inside thread "+getName()+ " "+i);
			synchronized(this) {
				j = j + 10;
			}
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		ThreadClass tc = new ThreadClass("one");
		ThreadClass tc1 = new ThreadClass("two");
		ThreadClass tc2 = new ThreadClass("three");
		ThreadClass tc3 = new ThreadClass("four");
		ThreadClass tc4 = new ThreadClass("five");
	}
}

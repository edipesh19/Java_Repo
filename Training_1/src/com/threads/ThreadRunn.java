package com.threads;

public class ThreadRunn implements Runnable{
	Thread t = null;
	public ThreadRunn(String name){
		t = new Thread(this);
		t.setName(name);
		t.start();
	}
	
	public void run(){
		for(int i=0;i<10;i++){
			System.out.println(" Inside thread "+t.getName()+ " "+i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		//Thread.currentThread();
		ThreadRunn tc = new ThreadRunn("one");
		ThreadRunn tc1 = new ThreadRunn("two");
		ThreadRunn tc2 = new ThreadRunn("three");
		ThreadRunn tc3 = new ThreadRunn("four");
		ThreadRunn tc4 = new ThreadRunn("five");
	}
}

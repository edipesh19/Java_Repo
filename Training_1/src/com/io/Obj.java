package com.io;

public class Obj{
	int i = 100;
	public Obj(){
	}

	public String toString(){
		return "test";
	}

	public boolean equals(Object o){
		if(o == null)
			return false;
		if(o instanceof Obj){
			Obj obj = (Obj)o;
		    if(obj.i == this.i){
				return true;
			}
		}
		return false;
	}

	public static void main(String s[]){
		Obj o = new Obj();
		System.out.println(o);
	}
}
package com.io;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.Serializable;

public class Customer implements Externalizable {
	
	int id;
	transient String name;
	
	public Customer(){
		
	}
	public Customer(int i){
		this.id = i;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
		System.out.println("inside set name...");
	}
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeChars(name);
		
	}
	@Override
	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
		name = in.readLine();
		
	}
	
	

}

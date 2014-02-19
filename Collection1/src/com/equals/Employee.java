package com.equals;

public class Employee implements Comparable<Employee>{
	private int Eid;
	private String Name;
	
	public Employee(int id, String name){
		Eid = id;
		Name = name;
	}
	
	public String getName(){
		return Name;
	}
	public String toString(){
		return "Employee ID = " + Eid + " " + "Name = " + Name;
	}
	
	public boolean equals(Object obj){
		if (this == obj)
			return true;
		if ((obj == null) || (obj.getClass() != this.getClass()) )
			return false;
		Employee emp = (Employee)obj;
		return Eid == emp.Eid && Name == emp.Name;
	}
	
	public int hashCode(){
		return Eid;
	}
// This Comparable Interface implementation will help to put the element 
	// 1. Element in sorted set
	// 2. Keys in sorted map
	// 3. use Collections.sort() function
	
	@Override
	public int compareTo(Employee e) {
		if (e.Eid != this.Eid){
			return new Integer(Eid).compareTo(e.Eid);
		}
		return Name.compareTo(e.Name);
	}
}

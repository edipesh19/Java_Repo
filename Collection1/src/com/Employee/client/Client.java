package com.Employee.client;
import java.util.*;

import com.equals.Employee;

public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// Equal Method Test
		Employee e1 = new Employee(1,"Dipesh");
		Employee e2 = new Employee(2,"Mani");
		Employee e3 = new Employee(1,"Dipesh");
		
		if (e1 == e3){
			System.out.println("e1 and e3 are == ");
		}
		if (e1 == e2){
			System.out.println("e1 and e2 are == ");
		}
		if (e2 == e3){
			System.out.println("e2 and e3 are == ");
		}
		
		if (e1.equals(e3)){
			System.out.println("e1 and e3 are Equals ");
		}
		if (e1.equals(e2)){
			System.out.println("e1 and e2 are Equals ");
		}
		if (e2.equals(e3)){
			System.out.println("e2 and e3 are Equals ");
		}
		
		// CompareTo is used by the following sort method
		Employee[] empArray = {new Employee(7,"ASS1"),new Employee(3,"DSS2"),new Employee(5,"BSS3"),new Employee(1,"CSS4") };
		Employee[] empArray1 = {new Employee(7,"ASS1"),new Employee(3,"DSS2"),new Employee(5,"BSS3"),new Employee(1,"CSS4") };
		
		for(Employee emp:empArray){
			System.out.println("Employee :" + emp);
		}
		
		List<Employee> empList = Arrays.asList(empArray);
		System.out.println("From ArrayList " + empList);
		System.out.println(Arrays.toString(empArray));
		Collections.sort(Arrays.asList(empArray));
		System.out.println(Arrays.toString(empArray));
		
		compareUse(empArray1);
		
	}
	
	private static void compareUse(Employee[] empArray){
		
		Set<Employee> treeSet = new TreeSet<Employee>(new CompareUse());
		for (Employee e: empArray){
			treeSet.add(e);
		}
		System.out.println(treeSet);
	}

}

class CompareUse implements Comparator<Employee>{

	@Override
	public int compare(Employee e1, Employee e2) {
		return e1.getName().compareTo(e2.getName());
	}
	
}

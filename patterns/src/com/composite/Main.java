package com.composite;

import java.util.Iterator;

public class Main {  
	  
	 public static void main(String[] args) {  
	  Main main = new Main();
	  Employee emp1=new Developer("John", 10000);  
	  Employee emp2=new Developer("David", 15000);  
	  Employee manager1=new Manager("Daniel",25000);  
	  manager1.add(emp1);  
	  manager1.add(emp2);  
	  
	  Employee emp4=new Developer("Sathish", 10000);  
	  Employee emp5=new Developer("Suresh", 15000); 
	  
	  Employee manager0=new Manager("raja",25000);  
	  manager0.add(emp4);  
	  manager0.add(emp5);  
	  
	  manager1.add(manager0);
	  
	  Employee emp3=new Developer("Michael", 20000);  
	  Manager generalManager=new Manager("Mark", 50000);  
	  generalManager.add(emp3);  
	  generalManager.add(manager1);  
	 // generalManager.print();
	  System.out.println("Starting the comp iterator ............");
	  CompositeIter iter = main.new CompositeIter(generalManager);
	  while (iter.hasNext()) {
		  Object obj = iter.next();
		  if(obj != null){
			  Employee employee = (Employee)obj;
			  employee.print();
			  System.out.println("*********************************************************");
		  }else{
			  break;
		  }
		
	}
	  
	 }  
	 
	 class CompositeIter implements Iterator<Employee>{
		 
		 private Employee emp;

		public CompositeIter(Employee emp){
			 this.emp = emp;
		 }

		@Override
		public boolean hasNext() {
			if(emp instanceof Manager){
				Manager man = (Manager)emp;
				if(man.employees.size() > 0){
					return true;
				}
			}
			return false;
		}

		@Override
		public Employee next() {
			Manager man = (Manager)emp;
			Iterator<Employee> iter = man.employees.iterator();
			while (iter.hasNext()) {
				Employee employee = (Employee) iter.next();
				if(employee instanceof Manager){ 
					// proceed to next level
					emp = employee;
					return employee;
				}else{
					// no need to do anything ... this is leaf node.
					Developer dev = (Developer)employee;
					System.out.println("No managers available in this Level "+dev.getName());
				}
				
			}
				return null;
		}

		@Override
		public void remove() {
			// not going to implement 
			throw new UnsupportedOperationException("Not implemented ...");
			
		}
		 
	 }
	 
	}  
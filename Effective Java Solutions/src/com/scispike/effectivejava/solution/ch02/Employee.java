package com.scispike.effectivejava.solution.ch02;

import java.util.Date;
import java.util.GregorianCalendar;

public class Employee {

	private String employeeNumber;
	private String firstName;
	private String lastName;
	private Date dob;
	private double salary;
	
	public Employee(String employeeNumber, String firstName, String lastName, Date dob, double salary) {
		this.employeeNumber = employeeNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.salary = salary;
	}
		
	public String getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(String employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public Date getDob() {
		return dob;
	}


	public void setDob(Date dob) {
		this.dob = dob;
	}


	public double getSalary() {
		return salary;
	}


	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (! (o instanceof Employee))
			return false;
		
		Employee e = (Employee)o;
		
		return ((e.employeeNumber == null && this.employeeNumber == null || 
				 e.employeeNumber != null && this.employeeNumber.equals(e.employeeNumber)) &&
				(e.firstName == null && this.firstName == null ||
				 e.firstName != null && this.firstName.equals(e.firstName)) &&
				(e.lastName == null && this.lastName == null ||
				 e.lastName != null && this.lastName.equals(e.lastName)) &&
				(e.dob == null && this.dob == null ||
				 e.dob != null && this.dob.equals(e.dob)) &&
				 Double.compare(this.salary, e.salary) == 0);
	}
	
	@Override
	public int hashCode() { // TODO
		int rslt = 17;
		
		int c = this.employeeNumber == null ? 0 : this.employeeNumber.hashCode();
		
		rslt = 31 * rslt + c;
		
		c = this.firstName == null ? 0 : this.firstName.hashCode();
		
		rslt = 31 * rslt + c;
		
		c = this.lastName == null ? 0 : this.lastName.hashCode();
		
		rslt = 31 * rslt + c;
		
		c = this.dob == null ? 0 : this.dob.hashCode();
		
		rslt = 31 * rslt + c;
		
		long doubleBits = (Double.doubleToLongBits(this.salary));
		rslt = 31 * rslt + (int) (doubleBits ^ (doubleBits >>> 32));

		return rslt;
	}
	
	@Override
	public String toString() {
		return String.format("{%s, %s %s, %s, %.2f}", employeeNumber, firstName, lastName, dob, salary);
	}
	
	public static void main(String[] args) throws Exception {
		Employee e = new Employee("0001", "John", "Smith", new GregorianCalendar(1980, 0, 1).getTime(), 30000.00);
		Employee e2 = new Employee("0001", "John", "Smith", new GregorianCalendar(1980, 0, 1).getTime(), 30000.00);
		System.out.println(e);
		System.out.println(e2);
		System.out.printf("e == e2 is %b\n", e.equals(e2));
		System.out.printf("e hashCode is %d\n", e.hashCode());
	}

}

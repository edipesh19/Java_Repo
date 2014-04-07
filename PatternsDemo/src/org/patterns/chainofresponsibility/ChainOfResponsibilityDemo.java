package org.patterns.chainofresponsibility;

abstract class Employee{
	private Employee next;
	
	public void setEmp(Employee emp) {
		this.next = emp;
	}
	
	public void add(Employee emp){
		if (next != null){
			next.add(emp);
		}
		else{
			next = emp;
		}
	}
	
	public void handle(int i){
		next.handle(i);
	}
}


class TeamMember extends Employee{
	@Override
	public void handle(int i){
		if (i%3 == 0){
			super.handle(i);
		}
		else{
			System.out.println("Handled by Team member");
			
		}
	}
}	

class TeamLead extends Employee{
	
	@Override
	public void handle(int i){
		if (i%2 == 0){
			super.handle(i);
		}
		else{
			System.out.println("Handled by Team Lead");
			
		}
	}
}	

class Manager extends Employee{
	
	@Override
	public void handle(int i){
			System.out.println("Handled by Manager");
			
		}
}	

public class ChainOfResponsibilityDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Manager manager = new Manager();
		TeamLead teamLead = new TeamLead();
		TeamMember teamMember = new TeamMember();
		
		teamMember.add(teamLead);
		teamMember.add(manager);
		
		
		for (int i = 0; i < 10; i++){
			
			teamMember.handle(i);
		}

	}

}

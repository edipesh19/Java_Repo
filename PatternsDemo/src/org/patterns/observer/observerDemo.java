package org.patterns.observer;

import java.util.ArrayList;

class DataBase{
	private ArrayList<Observer> observers = null;
	private int state;
	
	public DataBase(){
		observers = new ArrayList<Observer>();
		state = 0;
	}
	
	public int getState() {
		return state;
	}
	
	public void setState(int state) {
		this.state = state;
		notifyObservers();
	}
	
	public void subscribe(Observer observer){
		observers.add(observer);
	}
	
	private void notifyObservers(){
		for (Observer o : observers){
			o.update();
		}
	}
}

abstract class Observer{	
	DataBase db = null;
	protected int cachedState = 0;
	public Observer(DataBase db){
		this.db = db;
		cachedState = db.getState();
		db.subscribe(this);
	}
	
	public int getCachedState() {
		return cachedState;
	}
	public abstract void update();
}

class Admin extends Observer{
	public Admin(DataBase db){
		super(db);
	}
	@Override
	public void update() {
		cachedState = db.getState();
		System.out.println("Admin Cached Modified");
	}
}

class Developer extends Observer{
	public Developer(DataBase db){
		super(db);
	}
	@Override
	public void update() {
		cachedState = db.getState();
		System.out.println("Developer Cached Modified");
	}
}

class Architect extends Observer{
	public Architect(DataBase db){
		super(db);
	}
	@Override
	public void update() {
		cachedState = db.getState();
		System.out.println("Architect Cached Modified");
	}	
}

public class observerDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DataBase db = new DataBase();
		Admin admin = new Admin(db);
		Developer developer = new Developer(db);
		Architect architect = new Architect(db);
		
		System.out.println("After Update");
		System.out.println("Admin Cached = " + admin.getCachedState());
		System.out.println("Developer Cached = " + developer.getCachedState());
		System.out.println("Architect Cached = " + architect.getCachedState());
		
		System.out.println("Updating DB");
		db.setState(10);
		
		System.out.println("After Update");
		System.out.println("Admin Cached = " + admin.getCachedState());
		System.out.println("Developer Cached = " + developer.getCachedState());
		System.out.println("Architect Cached = " + architect.getCachedState());

	}
}

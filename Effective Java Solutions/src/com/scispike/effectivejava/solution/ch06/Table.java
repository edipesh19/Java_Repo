package com.scispike.effectivejava.solution.ch06;

import java.util.HashMap;
import java.util.Random;

public class Table {
	private int number;
	private int numberOfSeats;
	private static HashMap<Integer, Table> tables = new HashMap<Integer, Table>();
	
	private Table(int number, int numberOfSeats) {
		this.number = number;
		this.numberOfSeats = numberOfSeats;
	}

	public static Table getTable(int number) {
		Table rslt = tables.get(number);
		
		if (rslt == null) {
			rslt = new Table(number, 2 + new Random().nextInt(4));
			tables.put(number, rslt);
		}
		return rslt;
	}
	
	public int getNumber() {
		return number;
	}

	public int getNumberOfSeats() {
		return numberOfSeats;
	}
	
	@Override
	public String toString() {
		return String.format("[%d %d]", this.number, this.numberOfSeats);
	}
}

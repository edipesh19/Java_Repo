package com.iterator.use;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class IteratorUsage {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Collection<Integer> intList = new ArrayList<Integer>();
		int[] intArr = { 9, 11, -4, 1, 13, 99, 1, 0 };
		
		for (int a:intArr){
			intList.add(a);
		}
		System.out.println("Before = " + intList);
		
		Iterator<Integer> itr = intList.iterator();
		
		while(itr.hasNext()){
			int value = itr.next();
			if (value < 0 || value > 10)
				itr.remove();
		}
		
		System.out.println("After = " + intList);

	}
}

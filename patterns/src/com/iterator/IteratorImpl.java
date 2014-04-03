package com.iterator;

import java.util.Iterator;

public class IteratorImpl implements Iterator<Integer>{
	
	private int[] i;

	public IteratorImpl(int i[]){
		this.i = i;
	}

	@Override
	public boolean hasNext() {
		return false;
	}

	@Override
	public Integer next() {
		return null;
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException("Not supported now");
	}

}

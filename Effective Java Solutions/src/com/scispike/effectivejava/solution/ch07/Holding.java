package com.scispike.effectivejava.solution.ch07;

import java.math.BigDecimal;

public class Holding {
	private String symbol;
	private long numOfShares;
	private BigDecimal cost;
	
	public Holding(String symbol) {
		this.symbol = symbol;
		this.numOfShares = 0;
		this.cost = new BigDecimal(0.00);
	}
	
	public String getSymbol() {
		return symbol;
	}
	
	public long getNumOfShares() {
		return numOfShares;
	}
	
	public BigDecimal getCost() {
		return cost;
	}
	
	public void addToHolding(long numOfShares, BigDecimal sharePrice) {
		this.numOfShares += numOfShares;
		this.cost = this.cost.add(sharePrice.multiply(new BigDecimal(numOfShares)));
	}
	
	public void removeFromHolding(long numOfShares, BigDecimal sharePrice) {
		if (numOfShares > this.numOfShares) {
			throw new IllegalArgumentException("Not enough shares");
		}
		this.numOfShares -= numOfShares;
		this.cost = this.cost.subtract(sharePrice.multiply(new BigDecimal(numOfShares)));
	}
	
	public boolean canSell(long numOfSharesToSell) {
		return this.numOfShares >= numOfSharesToSell;
	}
	
	@Override
	public String toString() {
		return String.format("[%s %d %s]", this.symbol, this.numOfShares, this.cost);
	}
}

package com.scispike.effectivejava.solution.ch07;

import java.util.HashMap;

public class Portfolio {
	private HashMap<String, Holding> holdings;
	
	public Portfolio() {
		this.holdings = new HashMap<String, Holding>();
	}
	
	public int getNumberOfHoldings() {
		return holdings.size();
	}
	
	public String[] getHoldingSymbols() {
		String[] rslt = new String[holdings.size()];
		holdings.keySet().toArray(rslt);
		
		return rslt;
	}
	
	public Holding getHolding(String symbol) {
		return holdings.get(symbol);
	}
	
	public void modifyPortfolio(Trade trade) {
		String symbol = trade.getSymbol();
		Holding holding = holdings.get(symbol);
		
		if (holding == null) {
			holding = new Holding(symbol);
		}
		
		switch (trade.getAction()) {
		case BUY:
			holding.addToHolding(trade.getNumOfShares(), trade.getPrice());			
			break;
		case SALE:
			holding.removeFromHolding(trade.getNumOfShares(), trade.getPrice());	
			break;
		}
		
		holdings.put(symbol, holding);
	}
	
	public boolean canSell(String symbol, long numOfSharesToSell) {
		boolean rslt = false;
		
		Holding holding = holdings.get(symbol);
		
		if (holding != null && holding.canSell(numOfSharesToSell))
			rslt = true;
		
		return rslt;
	}
	
	@Override
	public String toString() {
		return this.holdings.toString();
	}
}

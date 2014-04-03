package com.scispike.effectivejava.solution.ch07;

import java.math.BigDecimal;
import java.util.Date;

public class Trade {
	private String symbol;
	private TradeAction action;
	private BigDecimal price;
	private int numOfShares;
	private Date tradeDate;
	
	public Trade(String symbol, TradeAction action, BigDecimal price, int numOfShares, Date tradeDate) {
		this.symbol = symbol;
		this.action = action;
		this.price = price;
		this.numOfShares = numOfShares;
		this.tradeDate = tradeDate;
	}

	public String getSymbol() {
		return symbol;
	}
	
	public TradeAction getAction() {
		return action;
	}

	public BigDecimal getPrice() {
		return price;
	}
	
	public int getNumOfShares() {
		return numOfShares;
	}

	public Date getTradeDate() {
		return tradeDate;
	}	
}

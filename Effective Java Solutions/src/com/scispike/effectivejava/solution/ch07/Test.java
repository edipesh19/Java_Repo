package com.scispike.effectivejava.solution.ch07;

import java.math.BigDecimal;
import java.util.Date;

public class Test {

	public static void main(String[] args) {
		Portfolio p = new Portfolio();
		Trade t = new Trade("AAPL", TradeAction.BUY, new BigDecimal(550.00), 100, new Date());		
		p.modifyPortfolio(t);		
		System.out.println(p);
		
		if (p.canSell("AAPL", 50)) {
			t = new Trade("AAPL", TradeAction.SALE, new BigDecimal(580.00), 50, new Date());
			p.modifyPortfolio(t);		
			System.out.println(p);
		}
		
		t = new Trade("INTC", TradeAction.BUY, new BigDecimal(21.00), 100, new Date());		
		p.modifyPortfolio(t);		
		System.out.println(p);
		
		System.out.println("Number of holdings in the portfolio: " + p.getNumberOfHoldings());
		
		String[] symbols = p.getHoldingSymbols();
		
		for (String s : symbols) {
			System.out.printf("%s: %s\n", s, p.getHolding(s));
		}
	}

}

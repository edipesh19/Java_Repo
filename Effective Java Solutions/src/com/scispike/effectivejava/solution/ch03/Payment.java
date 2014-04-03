package com.scispike.effectivejava.solution.ch03;

import java.util.Date;

public final class Payment {
	private final float amount;
	private final Date paymentDate;
	
	public Payment(float amount, Date paymentDate) {
        this.amount = amount;
        this.paymentDate = paymentDate;
    }
  
    public float getAmount() {
        return amount;
    }
  
    public Date getPaymentDate() {
        return this.paymentDate;
    }
    
    @Override
    public String toString() {
    	return String.format("{amount=%.2f, paymentDate=%s}", this.amount, this.paymentDate);
    }
    
    public Payment adjustPaymentAmount(float amount) {
    	return new Payment(this.amount + amount, this.paymentDate);
    }
    
    public static void main(String[] args) {
    	Payment p = new Payment(99.99f, new Date());
    	System.out.println(p);
    	System.out.println(p.adjustPaymentAmount(-10.00f));
    }
}

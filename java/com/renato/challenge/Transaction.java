package com.renato.challenge;

import java.util.Date;

public class Transaction {
	double amount;
	long timestamp;

	public Transaction() {
		
	}

	public Transaction(double amount, long timestamp) {
		setAmount(amount);
		setTimestamp(timestamp);
	}

	
	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public Date getDate() {
		return new Date(this.timestamp);
	}
	
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

}

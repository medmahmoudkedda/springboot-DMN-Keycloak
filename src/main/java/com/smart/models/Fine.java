package com.smart.models;

public class Fine {
	private double amount;
	private int points;
	public Fine() {}
	
	public Fine(double amount, int points) {
		super();
		this.amount = amount;
		this.points = points;
	}
	
	public double getAmount() {
		return amount;
	}
	
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public int getPoints() {
		return points;
	}
	
	public void setPoints(int points) {
		this.points = points;
	}

}

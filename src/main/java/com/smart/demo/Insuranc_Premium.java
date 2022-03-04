package com.smart.demo;

public class Insuranc_Premium {
	private boolean hasPreIncident;
	private int age;
	private double premium;
	
	public Insuranc_Premium() {
		
	}
	
	public boolean isHasPreIncident() {
		return hasPreIncident;
	}
	public void setHasPreIncident(boolean hasPreIncident) {
		this.hasPreIncident = hasPreIncident;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Insuranc_Premium(boolean hasPreIncident, int age) {
		super();
		this.hasPreIncident = hasPreIncident;
		this.age = age;
	}

	public double getPremium() {
		return premium;
	}

	public void setPremium(double premium) {
		this.premium = premium;
	}
	
	
	
	

}

package com.smart.models;

public class Traffic_Violation {
	private Violation violation;
	private Driver driver;
	
	public Traffic_Violation() {}
	
	public Traffic_Violation(Violation violation, Driver driver) {
		super();
		this.violation = violation;
		this.driver = driver;
	}
	public Violation getViolation() {
		return violation;
	}
	public void setViolation(Violation violation) {
		this.violation = violation;
	}
	public Driver getDriver() {
		return driver;
	}
	public void setDriver(Driver driver) {
		this.driver = driver;
	}
 
	@Override
	public String toString() {
		return "Traffic_Violation [violation=" + violation + ", driver=" + driver + "]";
	}
	
	
	
	
	
}

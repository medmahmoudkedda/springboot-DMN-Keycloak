package com.smart.models;

public class Driver {
	private int points;
	private int age;
	private boolean isSuspended = false;
	
	public Driver() {}
	
	public Driver(int points, int age) {
		this.points = points;
		 this.age = age;
	}
	
	public int getPoints() {
		return points;
	}
	
	public void setPoints(int points) {
		this.points = points;
	}
	
	public boolean isSuspended() {
		return isSuspended;
	}

	public void setSuspended(boolean isSuspended) {
		this.isSuspended = isSuspended;
	}

	public int getAge() {
		return this.age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Driver [points=" + points + ", age=" + age + "]";
	}
	
	
}

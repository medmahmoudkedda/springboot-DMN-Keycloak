package com.smart.demo;

public class Violation {
	private float actual_speed;
	private float speed_limit;
	private String type;
	
	
	public Violation() {}
	
	public Violation(float actual_speed, float speed_limit, String type) {
		super();
		this.actual_speed = actual_speed;
		this.speed_limit = speed_limit;
		this.type = type;
	}
	
	public float getActual_speed() {
		return actual_speed;
	}
	public void setActual_speed(float actual_speed) {
		this.actual_speed = actual_speed;
	}
	public float getSpeed_limit() {
		return speed_limit;
	}
	public void setSpeed_limit(float speed_limit) {
		this.speed_limit = speed_limit;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Violation [actual_speed=" + actual_speed + ", speed_limit=" + speed_limit + ", type=" + type + "]";
	}
	
	
	

}

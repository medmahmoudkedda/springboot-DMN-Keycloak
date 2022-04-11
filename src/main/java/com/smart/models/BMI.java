package com.smart.models;

public class BMI {
	
	private float height;
	private float weight;
	private String level = "Undefined";
	
	public BMI() {
		
	}
	
	public BMI(float height, float weight) {
		super();
		this.height = height;
		this.weight = weight;
	}
	public float getHeight() {
		return height;
	}
	public void setHeight(float height) {
		this.height = height;
	}
	
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return "BMI [height=" + height + "cm, weight=" + weight + "kg, level=" + level + "]";
	}
	
	

}

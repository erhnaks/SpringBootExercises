package com.qa.may.entity;

public class Car {
	
	private String brand;
	private String fuel;
	private Double	engine;
	
	public Car() {
		
		super();
	}

	public Car(String brand, String fuel, Double engine) {
		super();
		this.brand = brand;
		this.fuel = fuel;
		this.engine = engine;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getFuel() {
		return fuel;
	}

	public void setFuel(String fuel) {
		this.fuel = fuel;
	}

	public Double getEngine() {
		return engine;
	}

	public void setEngine(Double engine) {
		this.engine = engine;
	}

	@Override
	public String toString() {
		return "Car [brand=" + brand + ", fuel=" + fuel + ", engine=" + engine + "]";
	}
	
	

}

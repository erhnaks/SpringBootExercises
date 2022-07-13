package com.qa.may.entity;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Car {

	@Id // Primary Key
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String brand;
	private String fuel;
	private Double engine;

	public Car() { // Super(Always at the top)

		super();
	}

	public Car(String brand, String fuel, Double engine) {
		super();
		this.brand = brand;
		this.fuel = fuel;
		this.engine = engine;
	}

	public Car(Integer id, String brand, String fuel, Double engine) { // Constructor with an ID
		super();
		this.id = id;
		this.brand = brand;
		this.fuel = fuel;
		this.engine = engine;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
	public int hashCode() {
		return Objects.hash(brand, engine, fuel, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		return Objects.equals(brand, other.brand) && Objects.equals(engine, other.engine)
				&& Objects.equals(fuel, other.fuel) && Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Car [brand=" + brand + ", fuel=" + fuel + ", engine=" + engine + "]";
	}

}

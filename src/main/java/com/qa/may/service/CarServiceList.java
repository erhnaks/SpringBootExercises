package com.qa.may.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.may.entity.Car;

@Service

public class CarServiceList implements CarService {

	private List<Car> cars = new ArrayList<>();

	@Override
	public Car getById(int id) {

		return this.cars.get(id);
	}

	@Override
	public List<Car> getAll() {
		return this.cars;
	}

	@Override
	public Car create(Car car) {

		this.cars.add(car);
		return this.cars.get(this.cars.size() - 1);

	}

	@Override
	public void delete(int id) {
		this.cars.remove(id);
	}

	@Override
	public Car findByname(String brand) { // For loop to return search by name;
		for (Car car : this.cars) {
			if (car.getBrand().equals(brand))

				return car;

		}

		return null;
	}

	@Override
	public Car update(int id, String brand, String fuel, Double engine) {
		Car toUpdate = this.cars.get(id);

		if (brand != null)
			toUpdate.setBrand(brand);
		if (fuel != null)
			toUpdate.setFuel(fuel);
		if (engine != null)
			toUpdate.setEngine(engine);
		return toUpdate;
	}

	@Override
	public Car updateByPatch(int id, String brand, String fuel, Double engine) {
		Car toUpdate = this.cars.get(id);

		if (brand != null)
			toUpdate.setBrand(brand);
		if (fuel != null)
			toUpdate.setFuel(fuel);
		if (engine != null)
			toUpdate.setEngine(engine);
		return toUpdate;
	}

}

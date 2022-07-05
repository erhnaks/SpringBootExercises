package com.qa.may.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.qa.may.entity.Car;

@Service
@Primary
public class CarServiceList implements CarService {

	private List<Car> cars = new ArrayList<>();

	@Override
	public Car getById(int id) {
		// TODO Auto-generated method stub
		return this.cars.get(id);
	}

	@Override
	public List<Car> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Car create(Car car) {

		this.cars.add(car);
		return this.cars.get(this.cars.size() - 1);

	}

	@Override
	public Car update(int id, String brand, String fuel, int engine) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}

	public Car update(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}

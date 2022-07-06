package com.qa.may.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.qa.may.entity.Car;
import com.qa.may.repo.CarRepo;

@Service
@Primary
public class CarServiceDB implements CarService {

	@Autowired
	private CarRepo repo;

	@Override
	public Car getById(int id) {
		return this.repo.findById(id).get();

	}

	@Override
	public List<Car> getAll() {
		return this.repo.findAll();

	}

	@Override
	public Car create(Car car) {

		return this.repo.save(car);
	}

	@Override
	public Car update(int id, String brand, String fuel, Double engine) {
		Car toUpdate = this.getById(id);

		if (brand != null)
			toUpdate.setBrand(brand);
		if (fuel != null)
			toUpdate.setFuel(fuel);
		if (engine != null)
			toUpdate.setEngine(engine);
		return this.repo.save(toUpdate);

	}

	@Override
	public void delete(int id) {
		this.repo.deleteById(id);

	}

	@Override
	public Car findByname(String Brand) {
		return this.repo.findByBrandStartingWithIgnoreCase(Brand);
	}

	@Override
	public Car updateByPatch(int id, String brand, String fuel, Double engine) {
		Car toUpdate = this.getById(id);

		if (brand != null)
			toUpdate.setBrand(brand);
		if (fuel != null)
			toUpdate.setFuel(fuel);
		if (engine != null)
			toUpdate.setEngine(engine);
		return this.repo.save(toUpdate);
	}

}

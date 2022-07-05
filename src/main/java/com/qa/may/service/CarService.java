package com.qa.may.service;

import java.util.List;

import com.qa.may.entity.Car;

public interface CarService {
	
	
	Car getById(int id);
	
	List<Car> getAll();
	Car create(Car car);
	
	Car update(int id, String brand, String fuel, int engine);
	
	
	void delete(int id);

	Car update(int id);


}

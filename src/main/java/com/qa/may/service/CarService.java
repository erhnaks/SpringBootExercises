package com.qa.may.service;

import java.util.List;

import com.qa.may.entity.Car;

public interface CarService {

	Car getById(int id);

	List<Car> getAll();

	Car findByname(String Brand);

	Car create(Car car);

	Car update(int id, String brand, String fuel, Double engine);

	void delete(int id);

	Car updateByPatch(int id, String brand, String fuel, Double engine);

}

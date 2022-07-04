package com.qa.may.rest;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.may.entity.Car;

@RestController
public class CarController {
	
	private List<Car> cars  = new ArrayList<>();
	
	
	
	@GetMapping("/demoCar")
	public Car getDemoCar() {
		
		return new Car("Audi", "Petrol", 2.1);
		
	}
	
	
	
	@PostMapping("/createCar")
	public Car create(@RequestBody Car car) {
		
		System.out.println("Created: " + car);
		this.cars.add(car);
		return this.cars.get(this.cars.size() -1);
	}
	
	
	@PatchMapping("/updateCar/{id}")
	public void update(@PathVariable("id") int id, @PathParam("brand") String brand, @PathParam("fuel") String fuel,
			@PathParam("engine") Double engine) {
		System.out.println("ID: " + id);
		System.out.println("Brand: " + brand);
		System.out.println("Fuel: " + fuel);
		System.out.println("Engine: " + engine);
	}
	
	
	@DeleteMapping("/removeCar/{id}")
	public void delete(@PathVariable int id) {
		System.out.println("ID: " + id);
	}

}

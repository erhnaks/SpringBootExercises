package com.qa.may.rest;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.may.entity.Car;
import com.qa.may.service.CarService;

@RestController
public class CarController {

	@Autowired
	private CarService service;

	@GetMapping("/demoCar")
	public Car getDemoCar() {

		return new Car("Audi", "Petrol", 2.1);

	}

	@GetMapping("/carReadById/{id}")
	public Car getById(@PathVariable int id) {
		return this.service.getById(id);

	}

	@GetMapping("/carGetAll")
	public List<Car> getAll() {

		return this.service.getAll();
	}

	@GetMapping("getCarByName/{name}")
	public Car getCarByBrandName(@PathVariable String brand) {
		return this.service.findByname(brand);
	}

	@PostMapping("/createCar")
	public ResponseEntity<Car> create(@RequestBody Car car) {

		System.out.println("Created: " + car);

		Car created = this.service.create(car);

		return new ResponseEntity<Car>(created, HttpStatus.CREATED);

	}

	@PutMapping("/updateCar/{id}")
	public Car update(@PathVariable("id") int id, @PathParam("brand") String brand, @PathParam("fuel") String fuel,
			@PathParam("engine") Double engine) {

		return this.service.update(id, brand, fuel, engine);

	}

	@PatchMapping("/updateCarByPatch/{id}")
	public Car updateByPatch(@PathVariable("id") int id, @PathParam("brand") String brand,
			@PathParam("fuel") String fuel, @PathParam("engine") Double engine) {

		return this.service.update(id, brand, fuel, engine);

	}

	@DeleteMapping("/removeCar/{id}")
	public ResponseEntity<?> delete(@PathVariable int id) {
		this.service.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}

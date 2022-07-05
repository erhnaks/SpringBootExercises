package com.qa.may.rest;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.may.entity.Car;
import com.qa.may.service.CarService;

@RestController
public class CarController {

	// private List<Car> cars = new ArrayList<>();

	private CarService service;

	@GetMapping("/demoCar")
	public Car getDemoCar() {

		return new Car("Audi", "Petrol", 2.1);

	}

	@GetMapping("/carReadById/{id}")
	public Car getById(@PathVariable int id) {
		// System.out.println("ID: " + id);
		return this.service.getById(id);

	}

	@GetMapping("/carGetAll")
	public List<Car> getAllcars() {

		return this.service.getAll();
	}

	@PostMapping("/createCar")
	public ResponseEntity<Car> create(@RequestBody Car car) {

		System.out.println("Created: " + car);

		Car created = this.service.create(car);

		return new ResponseEntity<Car>(created, HttpStatus.CREATED);

	}

//	@PatchMapping("/updateCarPatch/{id}")
//	public void updateByPatch(@PathVariable("id") int id, @PathParam("brand") String brand,
//			@PathParam("fuel") String fuel, @PathParam("engine") Double engine) {
//		System.out.println("ID: " + id);
//		System.out.println("Brand: " + brand);
//		System.out.println("Fuel: " + fuel);
//		System.out.println("Engine: " + engine);
//	}

	@PutMapping("/updateCarPut/{id}")
	public Car updateByPut(@PathVariable("id") int id, @PathParam("brand") String brand, @PathParam("fuel") String fuel,
			@PathParam("engine") Double engine) {
//		System.out.println("ID: " + id);
//		System.out.println("Brand: " + brand);
//		System.out.println("Fuel: " + fuel);
//		System.out.println("Engine: " + engine);

		Car toUpdate = this.service.update(id, brand, fuel, id);
		toUpdate.setBrand(brand);
		toUpdate.setFuel(fuel);
		toUpdate.setEngine(engine);
		return toUpdate;

	}

	@DeleteMapping("/removeCar/{id}")
	public ResponseEntity<?> delete(@PathVariable int id) {
		//System.out.println("ID: " + id);
		this.service.delete(id);
		return ResponseEntity.noContent().build();
	}

}

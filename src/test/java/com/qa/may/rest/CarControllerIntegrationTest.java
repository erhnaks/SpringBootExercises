package com.qa.may.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.may.entity.Car;

@SpringBootTest
@AutoConfigureMockMvc // Setting up the testing class
@Sql(scripts = { "classpath:car-schema.sql",
		"classpath:car-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
public class CarControllerIntegrationTest {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private ObjectMapper mapper;

	@Test
	void testCreate() throws Exception {
		Car testCar = new Car("Lambo", "Petrol", 6.3);
		String testCarAsJSON = this.mapper.writeValueAsString(testCar);
		RequestBuilder req = post("/createCar").content(testCarAsJSON).contentType(MediaType.APPLICATION_JSON);

		ResultMatcher checkStatus = MockMvcResultMatchers.status().is(201);
		Car createdCar = new Car(2, "Lambo", "Petrol", 6.3);
		String createdCarAsJSON = this.mapper.writeValueAsString(createdCar);
		ResultMatcher checkBody = MockMvcResultMatchers.content().json(createdCarAsJSON);

		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}

	@Test
	void testUpdate() throws Exception {
		Car updatedCar = new Car(1, "Lambo", "Petrol", 6.3);
		String toJSON = this.mapper.writeValueAsString(updatedCar);
		ResultMatcher checkBody = MockMvcResultMatchers.content().json(toJSON);

		this.mvc.perform(patch("/updateCarByPatch/1?brand=Lambo&fuel=Petrol&engine=6.3")).andExpect(checkBody)
				.andExpect(status().isOk());
	}

	@Test
	void testUpdateByPatch() throws Exception {
		Car updatedCar = new Car(1, "Lambo", "Petrol", 6.3);
		String toJSON = this.mapper.writeValueAsString(updatedCar);
		ResultMatcher checkBody = MockMvcResultMatchers.content().json(toJSON);

		this.mvc.perform(patch("/updateCarByPatch/1?brand=Lambo&fuel=Petrol&engine=6.3")).andExpect(checkBody)
				.andExpect(status().isOk());
	}

	@Test
	void testReadByAll() throws Exception {

		List<Car> readCars = new ArrayList<>();
		readCars.add(new Car(1, "Volvo", "Hybrid", 2.2));
		String createdCarAsJSON = this.mapper.writeValueAsString(readCars);

		this.mvc.perform(get("/carGetAll")).andExpect(content().json(createdCarAsJSON)).andExpect(status().isOk());

	}

	@Test
	void testReadById() throws Exception {

		Car readCar = new Car(1, "Volvo", "Hybrid", 2.2);
		String createdCarAsJSON = this.mapper.writeValueAsString(readCar);

		this.mvc.perform(get("/carReadById/1")).andExpect(content().json(createdCarAsJSON)).andExpect(status().isOk());

	} // get url //body

	@Test
	void testReadByBrand() throws Exception {

		Car readCar = new Car(1, "Volvo", "Hybrid", 2.2);
		String createdCarAsJSON = this.mapper.writeValueAsString(readCar);

		this.mvc.perform(get("/findByName/Volvo")).andExpect(content().json(createdCarAsJSON))
				.andExpect(status().isOk());

	}

	@Test
	void testDelete() throws Exception {
		this.mvc.perform(delete("/removeCar/1")).andExpect(status().isNoContent());
	}

}

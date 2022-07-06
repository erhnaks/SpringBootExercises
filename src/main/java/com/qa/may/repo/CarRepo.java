package com.qa.may.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.may.entity.Car;

@Repository

public interface CarRepo extends JpaRepository<Car, Integer> {

	Car findByBrandStartingWithIgnoreCase(String brand);
}

package org.christruax.car.services;

import java.util.List;
import java.util.Optional;


import org.christruax.car.models.Car;
import org.christruax.car.repositories.CarRepo;
import org.springframework.stereotype.Service;

@Service
public class CarService {
	private final CarRepo cR;

	public CarService(CarRepo cR) {
		this.cR = cR;
	}
	
	public List<Car> getAllCars() {
		return cR.findAll();
	}

	public void createOrUpdateCar(Car car) {
		cR.save(car);
		
	}

	public Car getCarById(Long id) {
		Optional<Car> potentialCar = cR.findById(id);
		
		if(potentialCar.isPresent()) {
			return potentialCar.get();
		}
		return null;
	}

	public void removeCarById(Long id) {
		cR.deleteById(id);
		
	}
}

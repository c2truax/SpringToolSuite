package org.christruax.car.repositories;

import java.util.List;

import org.christruax.car.models.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepo extends CrudRepository<Car, Long> {
	List<Car> findAll();
}

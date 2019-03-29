package org.christruax.license.repositories;

import java.util.List;

import org.christruax.license.models.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepo  extends CrudRepository<Person, Long>{
	List<Person> findAll();
}

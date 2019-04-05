package org.christruax.dojosandninjas.repositories;

import java.util.List;

import org.christruax.dojosandninjas.models.Dojo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DojoRepo extends CrudRepository<Dojo, Long> {
	List<Dojo> findAll();
}

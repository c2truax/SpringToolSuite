package org.christruax.dojosandninjas.repositories;

import java.util.List;

import org.christruax.dojosandninjas.models.Ninja;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NinjaRepo extends CrudRepository<Ninja, Long> {
	List<Ninja> findAll();
}

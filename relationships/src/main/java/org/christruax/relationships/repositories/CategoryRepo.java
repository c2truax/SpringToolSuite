package org.christruax.relationships.repositories;

import java.util.List;

import org.christruax.relationships.models.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends CrudRepository<Category, Long> {
	List<Category> findAll();
	
	List<Category> findByNameNotIn(List<String> names);
}

package org.christruax.relationships.repositories;

import java.util.List;

import org.christruax.relationships.models.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends CrudRepository<Product, Long> {
	List<Product> findAll();

	List<Product> findByNameNotIn(List<String> productNames);
}

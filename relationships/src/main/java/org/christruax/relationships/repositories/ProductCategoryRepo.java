package org.christruax.relationships.repositories;


import java.util.List;

import org.christruax.relationships.models.ProductCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCategoryRepo extends CrudRepository<ProductCategory, Long> {
	List<ProductCategory> findAll();
}

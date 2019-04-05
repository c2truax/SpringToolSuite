package org.christruax.relationships.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.christruax.relationships.models.Category;
import org.christruax.relationships.models.Product;
import org.christruax.relationships.models.ProductCategory;
import org.christruax.relationships.repositories.CategoryRepo;
import org.christruax.relationships.repositories.ProductCategoryRepo;
import org.christruax.relationships.repositories.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {
	@Autowired
	private ProductRepo pR;
	@Autowired
	private CategoryRepo cR;
	@Autowired
	private ProductCategoryRepo pcR;

	public Product saveProduct(Product product) {
		return pR.save(product);
	}

	public Product getProductById(Long id) {
		Optional<Product> optionalProduct = pR.findById(id);
		if(optionalProduct.isPresent()) {
			return optionalProduct.get();
		} else {
			return null;
		}
	}

	public Category saveCategory(Category category) {
		return cR.save(category);
	}

	public Category getCategoryById(Long id) {
		Optional<Category> optionalCategory = cR.findById(id);
		if(optionalCategory.isPresent()) {
			return optionalCategory.get();
		} else {
			return null;
		}
	}

	public List<Category> getAllCategories() {
		return cR.findAll();
	}

	public void addCategoryToProduct(ProductCategory pc) {
		pcR.save(pc);
	}

	public List<Category> getAllNonCategoriesOfProduct(Product product) {
		List<String> categoryNames = new ArrayList<String>();
		if(product.getCategories().size() == 0 ) {
			categoryNames.add("");
		} else {
			for(Category c : product.getCategories()) {
				categoryNames.add(c.getName());
			}
		}
		
		return cR.findByNameNotIn(categoryNames);
	}
	//
	public List<Product> getAllProducts() {
		return pR.findAll();
	}

	public List<Product> getAllNonProductsOfCategory(Category category) {
		List<String> productNames = new ArrayList<String>();
		if(category.getProducts().size() == 0 ) {
			productNames.add("");
		} else {
			for(Product p : category.getProducts()) {
				productNames.add(p.getName());
			}
		}
		
		return pR.findByNameNotIn(productNames);
	}
}

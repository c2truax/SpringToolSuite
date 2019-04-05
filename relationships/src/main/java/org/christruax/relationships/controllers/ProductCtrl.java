package org.christruax.relationships.controllers;

import javax.validation.Valid;

import org.christruax.relationships.models.Product;
import org.christruax.relationships.models.ProductCategory;
import org.christruax.relationships.services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductCtrl {
	@Autowired
	private InventoryService iS;
	
	@GetMapping("/products/new")
	public String newProduct(@ModelAttribute("productObj") Product product) {
		return "/products/new.jsp";
	}
	
	@PostMapping("/products")
	public String createProduct(@Valid @ModelAttribute("productObj") Product product, BindingResult result) {
		if(result.hasErrors()) {
			return "/products/new.jsp";
		} else {
			Product savedProduct = iS.saveProduct(product);
			return "redirect:/products/" + savedProduct.getId();
		}
	}
	
	@GetMapping("/products/{id}")
	public String getProduct(@ModelAttribute("connectionObj") ProductCategory pc, @PathVariable("id") Long id, Model model) {
		Product p = iS.getProductById(id);
		model.addAttribute("productObj", p);
		model.addAttribute("nonCategories", iS.getAllNonCategoriesOfProduct(p));
		return "/products/show.jsp";
	}
	
	@PostMapping("/addCategory")
	public String addCategoryToProduct(@ModelAttribute("connectionObj") ProductCategory pc) {
		iS.addCategoryToProduct(pc);
		return "redirect:/products/" + pc.getProduct().getId();
	}
}

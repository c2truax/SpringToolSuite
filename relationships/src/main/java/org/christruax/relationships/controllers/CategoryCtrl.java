package org.christruax.relationships.controllers;

import javax.validation.Valid;

import org.christruax.relationships.models.Category;
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
public class CategoryCtrl {
	@Autowired
	private InventoryService iS;
	
	@GetMapping("/categories/new")
	public String newCategory(@ModelAttribute("categoryObj") Category category) {
		return "/categories/new.jsp";
	}
	
	@PostMapping("/categories")
	public String createCategory(@Valid @ModelAttribute("categoryObj") Category category, BindingResult result) {
		if(result.hasErrors()) {
			return "/categories/new.jsp";
		} else {
			Category savedCategory = iS.saveCategory(category);
			return "redirect:/categories/" + savedCategory.getId();
		}
	}
	
	@GetMapping("/categories/{id}")
	public String getCategory(@ModelAttribute("connectionObj") ProductCategory pc, @PathVariable("id") Long id, Model model) {
		Category c = iS.getCategoryById(id);
		model.addAttribute("nonProducts", iS.getAllNonProductsOfCategory(c));
		model.addAttribute("categoryObj", c);
		return "/categories/show.jsp";
	}
	
	@PostMapping("/addProduct")
	public String addCategoryToProduct(@ModelAttribute("connectionObj") ProductCategory pc) {
		iS.addCategoryToProduct(pc);
		return "redirect:/products/" + pc.getProduct().getId();
	}
}

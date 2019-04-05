package org.christruax.dojosandninjas.controllers;

import javax.validation.Valid;

import org.christruax.dojosandninjas.models.Dojo;
import org.christruax.dojosandninjas.services.DojoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DojoCtrl {
	@Autowired
	private DojoService dS;
	
	@GetMapping("/dojos/new")
	public String newDojo(@ModelAttribute("dojo") Dojo dojo) {
		return "/dojos/new.jsp";
	}
	
	@PostMapping("/dojos")
	public String create(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if (result.hasErrors()) {
			return "/dojos/new.jsp";
		} else {
			Dojo d = dS.createDojo(dojo);
			return "redirect:/dojos/" + d.getId();
		}
	}
	
	@GetMapping("/dojos/{id}")
	public String show(Model model, @PathVariable("id") Long id) {
		Dojo dojo = dS.getDojo(id);
		model.addAttribute("dojo", dojo);
		return "/dojos/show.jsp";
	}
}

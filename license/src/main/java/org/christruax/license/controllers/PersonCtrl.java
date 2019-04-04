package org.christruax.license.controllers;

import javax.validation.Valid;

import org.christruax.license.models.Person;
import org.christruax.license.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PersonCtrl {
	@Autowired
	private PersonService pS;
	
	@GetMapping("/people/new")
	public String newPerson(@ModelAttribute("person") Person person) {
		return "/people/new.jsp";
	}
	
	@PostMapping("/people")
	public String create(@Valid @ModelAttribute("person") Person person, BindingResult result) {
		if (result.hasErrors()) {
			return "/people/new.jsp";
		} else {
			Person p = pS.createPerson(person);
			return "redirect:/people/" + p.getId();
		}
	}
	
	@GetMapping("/people/{id}")
	public String show(Model model, @PathVariable("id") Long id) {
		Person person = pS.getPerson(id);
		model.addAttribute("person", person);
		return "/people/show.jsp";
	}
}

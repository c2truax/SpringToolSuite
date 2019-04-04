package org.christruax.license.controllers;

import java.util.List;

import javax.validation.Valid;

import org.christruax.license.models.License;
import org.christruax.license.models.Person;
import org.christruax.license.services.LicenseService;
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
public class LicenseCtrl {
	@Autowired
	private LicenseService lS;
	@Autowired
	private PersonService pS;
	
	
	
	@GetMapping("/licenses/new")
	public String newLicense(Model model, @ModelAttribute("license") License license) {
		List<Person> people = pS.allPeople();
		model.addAttribute("people", people);
		return "/licenses/new.jsp";
	}
	
	@PostMapping("/licenses")
	public String create(@Valid @ModelAttribute("license") License license, BindingResult result) {
		if (result.hasErrors()) {
			return "/licenses/new.jsp";
		} else {
			License savedLicense = lS.createLicense(license);
			License updatedLicense = lS.updateLicense(savedLicense);
			Person licensePerson = updatedLicense.getPerson();
			return "redirect:/people/" + licensePerson.getId();
		}
	}
	
	
}

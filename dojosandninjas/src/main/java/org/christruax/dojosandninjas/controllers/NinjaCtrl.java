package org.christruax.dojosandninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.christruax.dojosandninjas.models.Dojo;
import org.christruax.dojosandninjas.models.Ninja;
import org.christruax.dojosandninjas.services.DojoService;
import org.christruax.dojosandninjas.services.NinjaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class NinjaCtrl {
	@Autowired
	private NinjaService nS;
	@Autowired
	private DojoService dS;
	
	@GetMapping("/ninjas/new")
	public String newNinja(Model model, @ModelAttribute("ninja") Ninja ninja) {
		List<Dojo> dojos = dS.getDojos();
		model.addAttribute("dojos", dojos);
		return "/ninjas/new.jsp";
	}
	
	@PostMapping("/ninjas")
	public String create(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
		if (result.hasErrors()) {
			return "/ninjas/new.jsp";
		} else {
			Ninja n = nS.createNinja(ninja);
			Dojo d = n.getDojo();
			return "redirect:/dojos/" + d.getId();
		}
	}
}

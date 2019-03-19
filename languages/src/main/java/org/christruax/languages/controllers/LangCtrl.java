package org.christruax.languages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.christruax.languages.models.Language;
import org.christruax.languages.service.LangService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
public class LangCtrl {
	private final LangService lS;
	
	public LangCtrl(LangService lS) {
		this.lS = lS;
	}
	@GetMapping("/languages")
	public String index(Model model, @ModelAttribute("language") Language language) {
		List<Language> languages = lS.allLang();
		model.addAttribute("languages", languages);
		return "/languages/index.jsp";
	}
	@PostMapping("/languages")
	public String create(@Valid @ModelAttribute("language") Language language, BindingResult result, Model model) {
		if (result.hasErrors()) {
			List<Language> languages = lS.allLang();
			model.addAttribute("languages", languages);
			return "/languages/index.jsp";
		} else {
			lS.createLang(language);
			return "redirect:/languages";
		}
	}
	@GetMapping("/languages/{id}")
	public String show(Model model, @PathVariable("id") Long id) {
		Language lang = lS.getLang(id);
		model.addAttribute("language", lang);
		return "/languages/show.jsp";
	}
	@GetMapping("/languages/{id}/edit")
	public String edit(Model model, @PathVariable("id") Long id) {
		Language lang = lS.getLang(id);
		model.addAttribute("language", lang);
		return "/languages/edit.jsp";
	}
	@PutMapping("/languages/{id}")
	public String update(@Valid @ModelAttribute("language") Language language, BindingResult result) {
		if (result.hasErrors()) {
			return "/languages/edit.jsp";
		} else {
			lS.createLang(language);
			return "redirect:/languages";
		}
	}
	@DeleteMapping("/languages/{id}")
	public String delete(@PathVariable("id") Long id) {
		lS.deleteLang(id);
		return "redirect:/languages";
	}
}

package org.christruax.languages.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.christruax.languages.models.Language;
import org.christruax.languages.repositories.LangRepo;
import org.springframework.stereotype.Service;

@Service
public class LangService {
	private final LangRepo lR;
	
	public LangService(LangRepo lR) {
		this.lR = lR;
	}
	public List<Language> allLang() {
		return lR.findAll();
	}
	public Language createLang(Language lang) {
		return lR.save(lang);
	}
	public Language getLang(Long id) {
		Optional<Language> optionalLang = lR.findById(id);
		if (optionalLang.isPresent() == true) {
			return optionalLang.get();
		} else {
			return null;
		}
	}
	public void deleteLang(Long id) {
		lR.deleteById(id);
	}
}

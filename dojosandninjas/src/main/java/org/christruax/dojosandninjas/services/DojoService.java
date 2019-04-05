package org.christruax.dojosandninjas.services;

import java.util.List;
import java.util.Optional;

import org.christruax.dojosandninjas.models.Dojo;
import org.christruax.dojosandninjas.repositories.DojoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DojoService {
	@Autowired
	private DojoRepo dR;

	public Dojo createDojo(Dojo dojo) {
		return dR.save(dojo);
	}

	public Dojo getDojo(Long id) {
		Optional<Dojo> optionalDojo = dR.findById(id);
		if (optionalDojo.isPresent() == true) {
			return optionalDojo.get();
		} else {
			return null;
		}
	}

	public List<Dojo> getDojos() {
		return dR.findAll();
	}
	
	
}

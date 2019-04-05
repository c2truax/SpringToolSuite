package org.christruax.dojosandninjas.services;

import org.christruax.dojosandninjas.models.Ninja;
import org.christruax.dojosandninjas.repositories.NinjaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NinjaService {
	@Autowired
	private NinjaRepo nR;

	public Ninja createNinja(Ninja ninja) {		
		return nR.save(ninja);
	}
	
}

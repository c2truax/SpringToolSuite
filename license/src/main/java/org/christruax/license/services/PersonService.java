package org.christruax.license.services;

import org.christruax.license.repositories.PersonRepo;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
	private final PersonRepo pR;
	
	public PersonService(PersonRepo pR) {
		this.pR = pR;
	}
}

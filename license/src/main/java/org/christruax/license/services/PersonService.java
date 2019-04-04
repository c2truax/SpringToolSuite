package org.christruax.license.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;


import org.christruax.license.models.Person;
import org.christruax.license.repositories.PersonRepo;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
	private final PersonRepo pR;
	
	public PersonService(PersonRepo pR) {
		this.pR = pR;
	}

	public Person createPerson(Person person) {
		return pR.save(person);
	}

	public List<Person> allPeople() {
		return pR.findAll();
	}

	public Person getPerson(Long id) {
		Optional<Person> optionalPerson = pR.findById(id);
		if (optionalPerson.isPresent() == true) {
			return optionalPerson.get();
		} else {
			return null;
		}
	}
}

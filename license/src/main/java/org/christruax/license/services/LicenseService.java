package org.christruax.license.services;

import org.christruax.license.models.License;
import org.christruax.license.models.Person;
import org.christruax.license.repositories.LicenseRepo;
import org.springframework.stereotype.Service;

@Service
public class LicenseService {
	private final LicenseRepo lR;
	
	public LicenseService(LicenseRepo lR) {
		this.lR = lR;
	}

	public License createLicense(License license) {
		
		return lR.save(license);
	}
	
	public License updateLicense(License license) {
		//create license number;
		Person person = license.getPerson();
		String pId = String.valueOf(person.getId());
		String number = "";
		for(int i=0; i < 6 - pId.length(); i++ ) {
			number += "0";
		}
		number += pId;
		license.setNumber(number);
		return lR.save(license);
	}
}

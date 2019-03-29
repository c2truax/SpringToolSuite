package org.christruax.license.services;

import org.christruax.license.repositories.LicenseRepo;
import org.springframework.stereotype.Service;

@Service
public class LicenseService {
	private final LicenseRepo lR;
	
	public LicenseService(LicenseRepo lR) {
		this.lR = lR;
	}
}

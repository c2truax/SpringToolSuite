package org.christruax.license.repositories;

import java.util.List;

import org.christruax.license.models.License;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LicenseRepo  extends CrudRepository<License, Long>{
	List<License> findAll();
}

package org.christruax.languages.repositories;

import java.util.List;

import org.christruax.languages.models.Language;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LangRepo extends CrudRepository<Language, Long>{
	List<Language> findAll();
}

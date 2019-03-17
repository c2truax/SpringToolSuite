package org.christruax.bookmvc.repositories;

import java.util.List;

import org.christruax.bookmvc.models.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
	List<Book> findAll();
}

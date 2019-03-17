package org.christruax.bookmvc.services;

import java.util.List;
import java.util.Optional;

import org.christruax.bookmvc.models.Book;
import org.christruax.bookmvc.repositories.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookService {
	private final BookRepository bookRepository;
	
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    // creates a book
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }
    // retrieves a book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
    public Book updateBook(Long id, String title, String desc, String lang, Integer numOfPages) {
    	Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            Book b = optionalBook.get();
            b.setTitle(title);
            b.setDescription(desc);
            b.setLanguage(lang);
            b.setNumberOfPages(numOfPages);
            return bookRepository.save(b);
        } else {
            return null;
        }
    	
    }
    public void deleteBook(Long id) {
    	bookRepository.deleteById(id);
    }
}

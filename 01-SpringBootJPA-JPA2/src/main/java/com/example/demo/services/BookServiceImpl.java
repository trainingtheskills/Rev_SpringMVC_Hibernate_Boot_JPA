package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.BookRepository;
import com.example.demo.entity.Book;

@Service
public class BookServiceImpl implements BookService{

	private BookRepository bookrepository;
	
	@Autowired
	 public BookServiceImpl( 	BookRepository bookRepository) {
			this.bookrepository=bookRepository;
	}
	
	@Override
	public List<Book> findAll() {
			return bookrepository.findAll();
	}
	@Override
	public Book findById(int theId) {
		Optional<Book> result = bookrepository.findById(theId);
		Book theBook = null;
		
		if (result.isPresent()) {
			theBook = result.get();
		}
		else {
			throw new RuntimeException("Did not find book id - " + theId);
		}
		return theBook; 
	}

	@Override
	public void save(Book theEmployee) {
		bookrepository.save(theEmployee);		
	}

	@Override
	public void deleteById(int theId) {
		bookrepository.deleteById(theId);	
	}
}

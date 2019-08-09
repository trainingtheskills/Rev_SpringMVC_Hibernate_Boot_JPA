package com.example.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Book;
import com.example.demo.services.BookService;

// Make sure it resides in child package
@RestController
@RequestMapping("/")
public class BookController {
	
	BookService bookservice;
	
	@Autowired
	public BookController  (BookService thebookservice) {
		bookservice= thebookservice;	
	}
	
	@GetMapping("/books")
	public List<Book> getBooks()
	{//return " Hello Books";
		return bookservice.findAll();
	}
	
	@GetMapping("/books/{bookId}")
	public Book getBook(@PathVariable int bookId) {
		Book theBook = bookservice.findById(bookId);
		if (theBook == null) {
			throw new RuntimeException("Book id not found - " + bookId);
		}
		return theBook;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@PostMapping("/books")
	public Book addBook(@RequestBody Book theBook) {
		// also just in case they pass an id in JSON ... set id to 0
		// this is to force a save of new item ... instead of update
		theBook.setId(0);
		
		bookservice.save(theBook);		
		return theBook;
	}
	
	@PutMapping("/books")
	public Book updateEmployee(@RequestBody Book theBook) {
		
		bookservice.save(theBook);
		
		return theBook;
	}
	
	// 	
	@DeleteMapping("/books/{bookId}")
	public String deleteEmployee(@PathVariable int bookId) {
		
		Book tempBook= bookservice.findById(bookId);
		
		// throw exception if null
		
		if (tempBook == null) {
			throw new RuntimeException("Employee id not found - " + bookId);
		}
		
		bookservice.deleteById(bookId);
		
		return "Deleted book id - " + bookId;
	}
	
}
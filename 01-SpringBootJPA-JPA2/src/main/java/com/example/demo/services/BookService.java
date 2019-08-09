package com.example.demo.services;

import java.util.List;

import com.example.demo.entity.Book;

public interface BookService {
	 List<Book> findAll();
	
	public Book findById(int theId);
	
	public void save(Book theEmployee);
	
	public void deleteById(int theId);
	
}

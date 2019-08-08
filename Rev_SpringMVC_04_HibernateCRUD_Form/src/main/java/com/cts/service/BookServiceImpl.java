package com.cts.service;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cts.dao.BookDAO;
import com.cts.dao.BookDAOImpl;
import com.cts.model.Book;

@Service("bookService")
public class BookServiceImpl implements BookService {


	@Autowired
	BookDAOImpl bd;
	
	@Override
	@Transactional
	public void createBook(Book book) {
		bd.addBook(book);
	}

	@Override
	public Book getBookbyId(int BookId) {
		System.out.println("Book Id:"+BookId);
		return bd.fetchBookbyId(BookId);
	}

	@Override
	public void updateBookById(int BookId, Float price) {
		bd.updateBookById(BookId, price);
	}

	@Override
	public void deleteBookById(Integer BookId) {
		bd.deleteBookById(BookId);
	}


	@Override
	@Transactional
	public List<Book> listAllBooks()
	{   List  <Book> lb=bd.getAllBooks();
	System.out.println("list in serivce"+lb);
		return lb;
	}

}

package com.cts.dao;

import java.util.ArrayList;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cts.model.Book;


@Repository("bookDAO")
public class BookDAOImpl implements BookDAO {
	@Autowired
	 SessionFactory sessionFact;
	
	public java.util.List<Book> getAllBooks()
	{   	ArrayList<Book> booklist= new ArrayList<>();

		//Session session=sessionFact.openSession();
		Query query = sessionFact.getCurrentSession().createQuery("from Book");
		query.setMaxResults(3);
		booklist = (ArrayList<Book>) query.list();	
		System.out.println("list in dao"+booklist);

	return booklist;
	}
	
@Override
	public Book fetchBookbyId(int bookId) {
	Session currentSession = sessionFact.getCurrentSession();
    Book theBook = currentSession.get(Book.class, bookId);
    return theBook;	}

	@Override
	public void updateBookById(int Id, Float price) {
	}

	@Override
	public void deleteBookById(Integer BookId) {
		Session session = sessionFact.getCurrentSession();
        Book book = session.byId(Book.class).load(BookId);
        System.out.println(" Delete Called from dao"+book);
        session.delete(book);
	
	}
	@Override
	public void addBook(Book book) {
		sessionFact.getCurrentSession().saveOrUpdate(book);
		System.out.println(" Data Saved");		
	}


}

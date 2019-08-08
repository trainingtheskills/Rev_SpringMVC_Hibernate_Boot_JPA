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
/*		Book book = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			 book = session.get(Book.class,bookId );
			 System.out.println("Book Id was :"+bookId + "Object is "+ book);
			if(book != null){
				return book;
			}else{
				System.out.println("Book doesn't exist with provideded Id..");
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
*/		return null;
	}

	@Override
	public void updateBookById(int Id, Float price) {
		/*try (Session session = HibernateUtil.getSessionFactory().openSession()) {
System.out.println("Book to be updated :"+Id);
			Book book = session.get(Book.class, Id);
			if(book != null){
				book.setPrice(price);
				session.beginTransaction();
				System.out.println(" Book updated: "+book);
				session.update(book);
				session.getTransaction().commit();
			}else{
				System.out.println("Book doesn't exist with provideded Id..");
			}
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}
*/	}

	@Override
	public void deleteBookById(Integer BookId) {

		/*try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Book Book = session.get(Book.class, BookId);
			if(Book != null){
				session.beginTransaction();
				
				session.delete(Book);
				session.getTransaction().commit();
			}else{
				System.out.println("Book doesn't exist with provideded Id..");
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	*/
	}
	@Override
	public void addBook(Book book) {
		/*try (Session session = HibernateUtil.getSessionFactory().openSession()) {
		session.beginTransaction();
		System.out.println("Book Id in Service: "+book);
		session.persist(book);
		//Integer id =(Integer)session.save(book);
		//System.out.println("Book is created  with Id::"+id);
		session.getTransaction().commit();
	} catch (HibernateException e) {
		e.printStackTrace();
	}*/
		
	}


}

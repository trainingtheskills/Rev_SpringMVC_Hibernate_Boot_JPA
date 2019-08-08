
package com.cts.service ;
import java.util.List;

import com.cts.model.Book;



public interface BookService {
	/* void createBook(Book book);
	Book getBookbyId(int BookId);
	 void updateBookById(int BookId,Float price);
	void  deleteBookById(Integer BookId);*/
	public List<Book>listAllBooks();
}

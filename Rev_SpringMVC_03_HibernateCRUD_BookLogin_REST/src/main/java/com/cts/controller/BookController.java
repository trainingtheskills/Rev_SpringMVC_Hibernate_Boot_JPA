package com.cts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cts.exception.BookErrorResponse;
import com.cts.exception.BookNotFound;
import com.cts.model.Book;
import com.cts.service.BookService;
//Make sure you have JAckson dependency
@RestController
@RequestMapping("/api")
public class BookController {
	@Autowired
	BookService bs;
	
	@RequestMapping(value = "/books", method = RequestMethod.GET, produces={"application/json"})
	//public String listAllBooks(Model model)
	public List<Book> getBooks(){
		System.out.println(" Entered in List abook");
		List<Book> lb= bs.listAllBooks();
		//System.out.println(" Booklist: "+lb);
		//model.addAttribute("books"	,lb);
		return lb;
	}
	
	@RequestMapping(value="/books/{id}", method=RequestMethod.GET)
	public Book findBook(@PathVariable int id)
	{System.out.println(id);
		Book b= bs.getBookbyId(id);	
		if(b==null)
		 				throw new BookNotFound("Book ID not found -"+ id);
		return b;
	}
	
	

	
	@ExceptionHandler  
	public ResponseEntity<BookErrorResponse> handleException (BookNotFound exec)
	{System.out.println("Error");
		BookErrorResponse error= new BookErrorResponse();
		error.setStatusCode(HttpStatus.NOT_FOUND.value());
		error.setMessage(exec.getMessage());
		error.setTimestamp(System.currentTimeMillis());
		
		return new ResponseEntity<BookErrorResponse>(error,HttpStatus.NOT_FOUND);
	}
	

	//@RequestMapping(value="/book",method=RequestMethod.POST)
	@PostMapping("/books")
	public Book createBooks(@RequestBody  Book book)
	{	//System.out.println("Hello"+book);
		bs.createBook(book);
		return book;
	}
	
	@PutMapping("/books")
	public Book updateBooks(@RequestBody  Book book)
	{	System.out.println("Hello"+book);
		bs.createBook(book);
		return book;
	}
	
	
	@RequestMapping(value="/book/{id}",method=RequestMethod.DELETE)
	public String deleteBook(@PathVariable("id") int id)
	{ bs.deleteBookById(id);
		System.out.println("Delete Called");
		return "Deleted";
	}
	
	
	
	
	
	
	
	

	@RequestMapping(value="/book",method=RequestMethod.PUT)
	public String updateBook(@RequestBody  Book book)
	{ 	bs.createBook(book);
		return "Book Updated";
	}

	/*
  @GetMapping("/showForm")
	    public String showFormForAdd(Model theModel) {
		 System.out.println(" I will accept book data");
	        Book theBook = new Book();
	        theModel.addAttribute("book", theBook);
	        return "addbook";
	    }
	 
	 @PostMapping("/saveBook")
	    public String saveABook(@ModelAttribute("book") Book  theBook) {
	        bs.saveBook(theBook);
	        return "redirect:/book/list";

}
	
	 @GetMapping("/updateForm")
	    public String showFormForUpdate(@RequestParam("bookId") int theId,
	        Model theModel) {
	        Book theBook = bs.getBook(theId);
	        theModel.addAttribute("book", theBook);
	        return "addbook";
	    }
	 
	 @GetMapping("/delete")
	    public String deleteABook(@RequestParam("bookId") int theId) {
	        bs.deleteBook(theId);
	        return "redirect:/book/list";
	    }
	 */
}
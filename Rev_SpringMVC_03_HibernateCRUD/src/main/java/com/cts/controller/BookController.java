package com.cts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cts.model.Book;
import com.cts.service.BookService;

@Controller
@RequestMapping("/BookController")
public class BookController {

	@Autowired
	BookService bs;
	
	@GetMapping("/booklist")
	public String hello(Model model) {
		List <Book> al= bs.listAllBooks();
		System.out.println("List is :");
		al.forEach(System.out::println);
		return "bookList";	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@GetMapping("/showForm")
	public ModelAndView showBookForm(Model model) {
		Book book= new Book();
		ModelAndView m1= new ModelAndView("bookForm");
		m1.addObject("book",book);	
		return m1;
	}

	
//-------------------------Test with direct url------------------	
@RequestMapping(value="booklist/{uname}/{pass}",method=RequestMethod.GET)
public ModelAndView listAllBooksWithGreet(@PathVariable("uname") String username, @PathVariable("pass") String password)
		{System.out.println(" Welcome"+username+"And password is "+ password);
		return new ModelAndView("bookList","bookList"," Welcome"+username+ "List of Books");
		}

}

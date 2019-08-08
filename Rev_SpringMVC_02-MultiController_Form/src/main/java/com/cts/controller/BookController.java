package com.cts.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/BookController")
public class BookController {

	@GetMapping("/booklist")
	public String hello(Model model) {
		return "bookList";	
	}
	
	
	
	
	
	
	
	
	
	
	
	
//-------------------------Test with direct url------------------	
@RequestMapping(value="booklist/{uname}/{pass}",method=RequestMethod.GET)
public ModelAndView listAllBooksWithGreet(@PathVariable("uname") String username, @PathVariable("pass") String password)
		{System.out.println(" Welcome"+username+"And password is "+ password);
		return new ModelAndView("bookList","bookList"," Welcome"+username+ "List of Books");
		}

}

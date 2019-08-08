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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cts.exception.BookErrorResponse;
import com.cts.exception.BookNotFound;
import com.cts.model.Book;
import com.cts.model.Login;
import com.cts.service.BookService;
import com.cts.service.LoginService;
//Make sure you have JAckson dependency
@RestController
@RequestMapping("/logapi")
public class LoginBookController {
	@Autowired
	LoginService ls;
	
	@RequestMapping(value="/login/{email}", method=RequestMethod.GET)
	public Login findBook(@PathVariable String email)
	{System.out.println("Login: "+email);
		Login l= (Login) ls.findByEmail(email);
		//if(l==null)
		 //				throw new BookNotFound("Book ID not found -"+ id);
		return l;
	}

	@RequestMapping(value="/login",method=RequestMethod.POST)
	public Login createLogin(@RequestBody  Login login)
	{	ls.save(login);
		return login;
	}
	
}
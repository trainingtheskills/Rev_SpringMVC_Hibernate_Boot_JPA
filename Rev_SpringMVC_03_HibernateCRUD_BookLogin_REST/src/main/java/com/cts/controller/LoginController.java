package com.cts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.exception.BookErrorResponse;
import com.cts.exception.BookNotFound;
import com.cts.model.App_User;
import com.cts.model.Book;
import com.cts.service.UserServiceImpl;
@RestController
@RequestMapping("/logapi")

public class LoginController {
	@Autowired
	UserServiceImpl us;
	
	@GetMapping("/user/{username}")
	public App_User getUser(@PathVariable String uname){
		System.out.println(" Entered in Users");
		App_User theUser= us.getUserbyUsername(uname);
		//if(theUser==null)
			//	throw new BookNotFound("User  not found -"+ theUser);
		return theUser;
	}
	
	
	@PostMapping("/user")
	public App_User createUser(@RequestBody  App_User theUser)
	{	
		us.createUser(theUser);
		App_User user=us.getUserbyUsername(theUser.getUser_name());
		return theUser;
	}
		//return new ResponseEntity<BookErrorResponse>(error,HttpStatus.NOT_FOUND);
	}
	
	



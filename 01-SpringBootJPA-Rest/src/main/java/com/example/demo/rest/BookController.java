package com.example.demo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Make sure it resides in child package
@RestController
@RequestMapping("/")
public class BookController {
	
	@GetMapping("/books")
	public String getBooks()
	{return " Hello"; }

}

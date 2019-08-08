package com.cts.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	@GetMapping("/")
	public String hello(Model model) {

		//model.addAttribute("name", "John Doe");
		return "welcome";	
	}

	//@GetMapping("/hello")
	@RequestMapping(value="hello",method=RequestMethod.GET)
	public String hello() {
		ModelAndView model= new ModelAndView("welcome");
		model.addObject("name", "John Doe");
		return "welcome";	
	}
}

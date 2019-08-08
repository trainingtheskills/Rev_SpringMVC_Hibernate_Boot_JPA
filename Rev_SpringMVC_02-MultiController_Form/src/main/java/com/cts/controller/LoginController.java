package com.cts.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/LoginController")
public class LoginController {

	@GetMapping("/openlogin")
	public String hello(Model model) {
		return "loginPage";	
	}

	
/*	@GetMapping("/login")
	public String list(Model model) {
		return "listPage";	
	}*/

	@RequestMapping(value="login",method=RequestMethod.GET)
	public ModelAndView hello(@RequestParam("uname") String username,
						      @RequestParam("pass") String password) {
	return new ModelAndView("success","result",username+ "!");	
	}
}

package com.msedcl.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloWorldController {
	@GetMapping("/")
	public String showHomePage() {
		return "index";
	}
	
	@GetMapping("next")
	public String showNextPage() {
		return "second";
	}
	
//	@GetMapping("process")
//	public String printMessage(String message) {
//		System.out.println(message);
//		return "index";
//	}
	
	@GetMapping("process")
	public ModelAndView printMessage(String message) {
		System.out.println(message);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("third");
		modelAndView.addObject("msg",message);
		return modelAndView;
	}
	
}

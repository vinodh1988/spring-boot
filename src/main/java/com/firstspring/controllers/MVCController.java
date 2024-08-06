package com.firstspring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.firstspring.service.DataService;

@Controller
@RequestMapping("/app24")
public class MVCController {

	@Autowired
	@Qualifier("dservice")
	private DataService service;
	
	 @RequestMapping("/hello")
	 public String getHome(ModelMap m) {
		 
		 //business logic
		 m.addAttribute("team", service.getDevelopers());
		 return "home";
	 }
}

package com.firstspring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.firstspring.service.DataService;
import com.firstspring.utilities.ApplicationRequestCounter;
import com.firstspring.utilities.RequestCounter;

@Controller
@RequestMapping("/app24")
public class MVCController {

	@Autowired
	@Qualifier("dservice")
	
	
	private DataService service;
	
	@Autowired
	private RequestCounter counter;
	
	@Autowired
    private ApplicationRequestCounter acounter;
	
	 @RequestMapping("/hello")
	 public String getHome(ModelMap m) {
		 
		 //business logic
		 counter.setCounter();
		 acounter.setCounter();
		 m.addAttribute("team", service.getDevelopers());
		 m.addAttribute("scount",counter.getCounter());
		 m.addAttribute("acount",acounter.getCounter());
		 return "home";
	 }
}

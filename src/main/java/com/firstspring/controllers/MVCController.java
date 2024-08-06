package com.firstspring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/app24")
public class MVCController {

	 @RequestMapping("/hello")
	 public String getHome() {
		 //business logic
		 return "home";
	 }
}

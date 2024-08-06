package com.firstspring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.firstspring.service.DataService;

@RestController
@RequestMapping("/api/general")
public class GeneralAPI {

@Autowired
@Qualifier("dservice")
 private DataService x;

@Autowired
 private DataService tservice;
	
	{
		System.out.println("GENERAL API INSTANTIATED");
	}
	
	@GetMapping("/programmers")
	public String[] getProgrammers() {
		return x.getDevelopers();
	}
	
	@GetMapping("/testers")
	public String[] getTesters() {
		return tservice.getDevelopers();
	}
}

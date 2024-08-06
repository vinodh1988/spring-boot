package com.firstspring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.firstspring.repositories.ProjectRepository;

import jakarta.annotation.PostConstruct;

@Service
public class ProjectService {

	@Autowired
	private ProjectRepository prepo;
	
	@PostConstruct
	public void init()
	{
		System.out.println("Inject class: "+prepo.getClass().getName());
	}
	
	public List<Project> getProjects(){
		return  prepo.findAll();
	}
	
}

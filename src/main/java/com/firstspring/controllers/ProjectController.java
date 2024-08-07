package com.firstspring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.firstspring.entities.Project;
import com.firstspring.service.ProjectService;
import com.firstspring.utilities.RecordAlreadyExistsException;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

	@Autowired
	private ProjectService pservice;
	
	@GetMapping("")
	public List<Project> getProjects() {
	   return pservice.getProjects();	
	}
	
	@PostMapping("")
	public ResponseEntity<String> addProject(@RequestBody Project project) {
		try {
			pservice.addProject(project);
			return new ResponseEntity<String>("Record Added",HttpStatus.OK);
		}
		catch(RecordAlreadyExistsException e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}

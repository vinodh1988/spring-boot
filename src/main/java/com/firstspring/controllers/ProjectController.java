package com.firstspring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.firstspring.entities.Project;
import com.firstspring.service.ProjectService;
import com.firstspring.utilities.RecordAlreadyExistsException;
import com.firstspring.utilities.RecordNotFoundException;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

	@Autowired
	private ProjectService pservice;
	
	/*@GetMapping("")
	public List<Project> getProjects() {
	   return pservice.getProjects();	
	}*/
	
	@GetMapping("")
	public ResponseEntity<List<Project>> getProjects(@RequestParam(required = false) Integer min,@RequestParam(required = false) Integer max) {
	   try {
		   if(min==null && max==null)
			   return new ResponseEntity<>(pservice.getProjects(),HttpStatus.OK);
		  return new ResponseEntity<>(pservice.getProjectsBySize(min, max),HttpStatus.OK);	
	   }
	  
	   catch(Exception e) {
		   return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	   }
	}
	
	@GetMapping("/{projectno}")
	public ResponseEntity<Project> getProjects(@PathVariable Integer projectno) {
	   try {
		return new ResponseEntity<Project>(pservice.getProject(projectno),HttpStatus.OK);	
	   }
	   catch(RecordNotFoundException e) {
		   return new ResponseEntity<Project>(HttpStatus.NO_CONTENT);
	   }
	   catch(Exception e) {
		   return new ResponseEntity<Project>(HttpStatus.INTERNAL_SERVER_ERROR);
	   }
	}
	
	@PostMapping("")
	public ResponseEntity<String> addProject(@RequestBody Project project) {
		try {
			pservice.addProject(project);
			return new ResponseEntity<String>("Record Added",HttpStatus.CREATED);
		}
		catch(RecordAlreadyExistsException e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.OK);
		}
		catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}

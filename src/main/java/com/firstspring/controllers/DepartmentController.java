package com.firstspring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.firstspring.entities.Department;
import com.firstspring.entities.Project;
import com.firstspring.service.DepartmentService;
import com.firstspring.utilities.RecordAlreadyExistsException;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {
	@Autowired
	private DepartmentService dservice;

	 @GetMapping("")
	 public List<Department> getDepartments() {
		 return dservice.getDepartments();
	 }
	 
	 @PostMapping("")
		public ResponseEntity<String> addDepartment(@RequestBody Department dept) {
			try {
			    dservice.addDepartment(dept);
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

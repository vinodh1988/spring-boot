package com.firstspring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.firstspring.entities.Department;
import com.firstspring.repositories.DepartmentRepository;

@Service
public class DepartmentService {

	 @Autowired
	 private DepartmentRepository drepo;
	 
	 public  List<Department> getDepartments() {
		 return drepo.findAll();
	 }
}

package com.firstspring.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.firstspring.entities.Department;
import com.firstspring.repositories.DepartmentRepository;
import com.firstspring.utilities.RecordAlreadyExistsException;

@Service
public class DepartmentService {

	 @Autowired
	 private DepartmentRepository drepo;
	 
	 public  List<Department> getDepartments() {
		 return drepo.findAll();
	 }
	 
	 public void addDepartment(Department d) throws RecordAlreadyExistsException
		{
			try {
				Department dd=drepo.getDepartmentByDno(d.getDno());
				if(dd==null) {
					Set<Employee> eset=d.getEmployees();
					drepo.save(d);
				}
				else
					throw new RecordAlreadyExistsException();
					
			}
			catch (RecordAlreadyExistsException e) {
				// TODO: handle exception
				throw e;
			}
		}
}

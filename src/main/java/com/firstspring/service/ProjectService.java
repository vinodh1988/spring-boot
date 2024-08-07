package com.firstspring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.firstspring.entities.Project;
import com.firstspring.repositories.ProjectRepository;
import com.firstspring.utilities.RecordAlreadyExistsException;

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
	
	public void addProject(Project p) throws RecordAlreadyExistsException
	{
		try {
			Project pr=prepo.findByProjectno(p.getProjectno());
			if(pr==null)
				throw new RecordAlreadyExistsException();
			else
				prepo.save(p);
		}
		catch (RecordAlreadyExistsException e) {
			// TODO: handle exception
			throw e;
		}
	}
	
}

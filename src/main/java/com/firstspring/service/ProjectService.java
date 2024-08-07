package com.firstspring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.firstspring.entities.Project;
import com.firstspring.repositories.ProjectRepository;
import com.firstspring.utilities.RecordAlreadyExistsException;
import com.firstspring.utilities.RecordNotFoundException;

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
	
	public List<Project> getProjectsBySize(int min,int max){
		return  prepo.findByTeamsize(min, max);
	}
	
	
	public Project getProject(Integer projectno) throws RecordNotFoundException
	{
	
			Project pr=prepo.findByProjectno(projectno);
			if(pr!=null)
				return pr;
			throw new RecordNotFoundException();
		
	}
	public void addProject(Project p) throws RecordAlreadyExistsException
	{
		try {
			Project pr=prepo.findByProjectno(p.getProjectno());
			if(pr==null)
				prepo.save(p);
			else
				throw new RecordAlreadyExistsException();
				
		}
		catch (RecordAlreadyExistsException e) {
			// TODO: handle exception
			throw e;
		}
	}
	
	public void updateProject(Project p) throws Exception
	{
		
		//This method definition assumes that project object has all the properties filled
		// and no property is null
		// in real implementation we should address null columns also
		if(p.getProjectno()==null)
			throw new Exception();
		Project pr=prepo.findByProjectno(p.getProjectno());
		
		if(pr!=null) {
			p.setTeamsize(p.getTeamsize()==null?pr.getTeamsize():p.getTeamsize());
			p.setName(p.getName()==null?pr.getName():p.getName());
			prepo.save(p);
		}
		else
		    throw new RecordNotFoundException();
		
	}
	
	public void deleteProject(Integer projectno) throws RecordNotFoundException{
	   Project pr=	prepo.findByProjectno(projectno);
	   if(pr!=null)
		   prepo.delete(pr);
	   else
		   throw new RecordNotFoundException();
	}
	
}

package com.firstspring.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="projects")
public class Project {


	@Id
	private Integer projectno;
	@Column
	private String name;
	@Column
	private Byte teamsize;
	
	public Integer getProjectno() {
		return projectno;
	}
	public void setProjectno(Integer projectno) {
		this.projectno = projectno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Byte getTeamsize() {
		return teamsize;
	}
	public void setTeamsize(Byte teamsize) {
		this.teamsize = teamsize;
	}
	
	
}

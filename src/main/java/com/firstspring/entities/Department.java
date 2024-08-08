package com.firstspring.entities;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="departments")
public class Department {
  @Id
  private Integer dno;
  @Column
  private String dname;
  
  @OneToMany(mappedBy = "dept", cascade =CascadeType.ALL)
  private Set<Employee> employees;
  
public Integer getDno() {
	return dno;
}
public void setDno(Integer dno) {
	this.dno = dno;
}
public String getDname() {
	return dname;
}
public void setDname(String dname) {
	this.dname = dname;
}
public Set<Employee> getEmployees() {
	return employees;
}
public void setEmployees(Set<Employee> employees) {
	this.employees = employees;
}
  
  
}

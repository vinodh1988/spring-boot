package com.firstspring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.firstspring.entities.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
  public Department getDepartmentByDno(Integer dno);
}

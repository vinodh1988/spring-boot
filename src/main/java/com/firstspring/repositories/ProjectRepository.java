package com.firstspring.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.firstspring.entities.Project;

public interface ProjectRepository extends JpaRepository<Project, Integer> {
    public Project findByProjectno(Integer projectno);
}


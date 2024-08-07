package com.firstspring.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.firstspring.entities.Project;

public interface ProjectRepository extends JpaRepository<Project, Integer> {
    public Project findByProjectno(Integer projectno);
    
    public Project findByName(String name);
    
    @Query("SELECT p FROM Project p where p.teamsize between :minsize and :maxsize")
    public List<Project> findByTeamsize(@Param("minsize")int min, @Param("maxsize")int max);
}


package com.firstspring.repositories;

import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;

import com.firstspring.entities.Project;

public interface ProjectRepository extends JpaRepository<Project, Integer> {
  
}


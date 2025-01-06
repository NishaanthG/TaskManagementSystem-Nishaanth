package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.Model.Project;


/**
 * Repository interface for managing Porject entities.
 * Extends JpaRepository to provide CRUD operations and additional JPA functionalities.
 */
public interface ProjectRepository extends JpaRepository<Project, Integer>{
	
	

}

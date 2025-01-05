package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Project;
import java.util.List;
import java.util.Date;


public interface ProjectRepository extends JpaRepository<Project, Integer>{
	
	

}

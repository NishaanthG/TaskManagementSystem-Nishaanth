package com.example.demo.Repository;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.Model.TaskCategory;
import com.example.demo.Model.TaskCategoryID;

/**
 * Repository interface for managing TaskCategory entities.
 * Extends JpaRepository to provide CRUD operations and additional JPA functionalities.
 */
public interface TaskCategoryRepository extends JpaRepository<TaskCategory, TaskCategoryID>{
	
}

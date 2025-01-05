package com.example.demo.Repository;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.Model.TaskCategory;
import com.example.demo.Model.TaskCategoryID;

public interface TaskCategoryRepository extends JpaRepository<TaskCategory, TaskCategoryID>{
	
}

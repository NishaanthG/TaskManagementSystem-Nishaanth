package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.Model.Category;

/**
 * Repository interface for managing Category entities.
 * Extends JpaRepository to provide CRUD operations and additional JPA functionalities.
 */
public interface CategoryRepository extends JpaRepository<Category, Integer>{
	
}
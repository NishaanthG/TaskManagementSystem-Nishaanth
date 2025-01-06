package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Comment;

/**
 * Repository interface for managing comment entities.
 * Extends JpaRepository to provide CRUD operations and additional JPA functionalities.
 */
public interface CommentRepository extends JpaRepository<Comment, Integer>{

}

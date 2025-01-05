package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer>{

}

package com.example.demo.Service;

import java.util.List;

import com.example.demo.Model.Comment;
import com.example.demo.dto.CommentDTO;

public interface CommentService {
	
	public void addComment(CommentDTO c);

	public void DeleteCommentById(int commentid);
	
	public void UpdateComment(int commentid , Comment c1);

	public List<Comment> getAllComments();

	public Comment getCommentById(int commentid);
	
}

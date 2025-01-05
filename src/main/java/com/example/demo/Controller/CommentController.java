package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Comment;
import com.example.demo.Service.CommentService;
import com.example.demo.Success.SuccessResponse;
import com.example.demo.dto.CommentDTO;

import jakarta.validation.Valid;

@RestController
public class CommentController {
	
	@Autowired
	private CommentService cs;
	
	@DeleteMapping("/api/comments/delete/{commentId}")
	public ResponseEntity<SuccessResponse> DeleteCommentById(@PathVariable int commentId){
		cs.DeleteCommentById(commentId);
		
		return ResponseEntity.ok(new SuccessResponse("DELETESUCCESS","Comment deleted successfully"));
	}
	
	@RequestMapping(value = "/api/comments/post" , method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<SuccessResponse> AddNewComment(@Valid @RequestBody CommentDTO c){
		
		cs.addComment(c);
		
		return ResponseEntity.ok(new SuccessResponse("POSTSUCCESS","Commennts added successfully"));
	}
	
	@PutMapping("/api/comments/update/{commentId}")
	public ResponseEntity<SuccessResponse> UpdateComment(@PathVariable int commentId , @Valid @RequestBody Comment c){
		cs.UpdateComment(commentId, c);
		
		return ResponseEntity.ok(new SuccessResponse("UPDATESUCCESS" , "Comment Updated Successfully"));
	}

}

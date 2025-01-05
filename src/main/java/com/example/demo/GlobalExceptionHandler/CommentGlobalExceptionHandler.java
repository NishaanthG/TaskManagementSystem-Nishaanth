package com.example.demo.GlobalExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.Exception.DeleteCommentFailsException;
import com.example.demo.Exception.ErrorResponse;
import com.example.demo.Exception.PostNewCommentFailsException;
import com.example.demo.Exception.UpdateCommentFailsException;

@ControllerAdvice
public class CommentGlobalExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handlePostNewCommentFailsException(PostNewCommentFailsException e){
		ErrorResponse e1 = new ErrorResponse();
		e1.setCode(e.getCode());
		e1.setMessage(e.getMessage());
		
		return new ResponseEntity<ErrorResponse>(e1,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleUpdateCommentFailsException(UpdateCommentFailsException e){
		ErrorResponse e1 = new ErrorResponse();
		e1.setCode(e.getCode());
		e1.setMessage(e.getMessage());
		
		return new ResponseEntity<ErrorResponse>(e1,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> HandleDeleteCommentFailsException(DeleteCommentFailsException e){
		ErrorResponse e1 = new ErrorResponse();
		e1.setCode(e.getCode());
		e1.setMessage(e.getMessage());
		
		return new ResponseEntity<ErrorResponse>(e1,HttpStatus.INTERNAL_SERVER_ERROR);
	}

}

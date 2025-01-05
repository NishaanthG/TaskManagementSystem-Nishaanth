package com.example.demo.GlobalExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.Exception.ErrorResponse;
import com.example.demo.Exception.PostNewCommentFailsException;
import com.example.demo.Exception.TasksByPriorityAndStatusListEmptyException;
import com.example.demo.Exception.TasksByUserIDAndStatusEmptyListException;
import com.example.demo.Exception.TasksDueSoonListEmptyException;

@ControllerAdvice
public class TaskGlobalExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleTasksByPriorityAndStatusListEmptyException(TasksByPriorityAndStatusListEmptyException e){
		ErrorResponse e1 = new ErrorResponse();
		e1.setCode(e.getCode());
		e1.setMessage(e.getMessage());
		
		return new ResponseEntity<ErrorResponse>(e1,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleTasksDueSoonListEmptyException(TasksDueSoonListEmptyException e){
		ErrorResponse e1 = new ErrorResponse();
		e1.setCode(e.getCode());
		e1.setMessage(e.getMessage());
		
		return new ResponseEntity<ErrorResponse>(e1,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleTasksByUserIDAndStatusEmptyListException(TasksByUserIDAndStatusEmptyListException e){
		ErrorResponse e1 = new ErrorResponse();
		e1.setCode(e.getCode());
		e1.setMessage(e.getMessage());
		
		return new ResponseEntity<ErrorResponse>(e1,HttpStatus.NOT_FOUND);
	}

}

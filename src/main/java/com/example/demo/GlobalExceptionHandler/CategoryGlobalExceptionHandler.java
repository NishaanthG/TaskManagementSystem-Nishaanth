package com.example.demo.GlobalExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.Exception.CategoryListEmptyException;
import com.example.demo.Exception.CategoryWithTaskCountListEmptyException;
import com.example.demo.Exception.DeleteCategoryFailsException;
import com.example.demo.Exception.ErrorResponse;
import com.example.demo.Exception.UpdateCategoryFailsException;
import com.example.demo.Exception.categoryObjectNotFoundException;

@ControllerAdvice
public class CategoryGlobalExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleCategoryListEmptyException(CategoryListEmptyException e){
		ErrorResponse e1 = new ErrorResponse();
		e1.setCode(e.getCode());
		e1.setMessage(e.getMessage());
		
		return new ResponseEntity<ErrorResponse>(e1,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleCategoryObjectNotFoundExceptionException(categoryObjectNotFoundException e){
		ErrorResponse e1 = new ErrorResponse();
		e1.setCode(e.getCode());
		e1.setMessage(e.getMessage());
		
		return new ResponseEntity<ErrorResponse>(e1,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleCategoryWithTaskCountListEmptyException(CategoryWithTaskCountListEmptyException e){
		ErrorResponse e1 = new ErrorResponse();
		e1.setCode(e.getCode());
		e1.setMessage(e.getMessage());
		
		return new ResponseEntity<ErrorResponse>(e1,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleDeleteCategoryFailsException(DeleteCategoryFailsException e){
		ErrorResponse e1 = new ErrorResponse();
		e1.setCode(e.getCode());
		e1.setMessage(e.getMessage());
		
		return new ResponseEntity<ErrorResponse>(e1,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleUpdateCategoryFailsException(UpdateCategoryFailsException e){
		ErrorResponse e1 = new ErrorResponse();
		e1.setCode(e.getCode());
		e1.setMessage(e.getMessage());
		
		return new ResponseEntity<ErrorResponse>(e1,HttpStatus.NOT_FOUND);
	}

}

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

/**
 * Global Exception Handler for handling exceptions related to Category operations.
 * This class provides centralized exception handling across the application.
 */
@ControllerAdvice
public class CategoryGlobalExceptionHandler {

    /**
     * Handles CategoryListEmptyException when no categories are found.
     * 
     * @param e the exception thrown when the category list is empty
     * @return ResponseEntity containing the error response with HTTP status NOT_FOUND
     */
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleCategoryListEmptyException(CategoryListEmptyException e) {
        ErrorResponse e1 = new ErrorResponse();
        e1.setCode(e.getCode());
        e1.setMessage(e.getMessage());

        return new ResponseEntity<ErrorResponse>(e1, HttpStatus.NOT_FOUND);
    }

    /**
     * Handles categoryObjectNotFoundException when a specific category is not found.
     * 
     * @param e the exception thrown when the category object is not found
     * @return ResponseEntity containing the error response with HTTP status NOT_FOUND
     */
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleCategoryObjectNotFoundExceptionException(categoryObjectNotFoundException e) {
        ErrorResponse e1 = new ErrorResponse();
        e1.setCode(e.getCode());
        e1.setMessage(e.getMessage());

        return new ResponseEntity<ErrorResponse>(e1, HttpStatus.NOT_FOUND);
    }

    /**
     * Handles CategoryWithTaskCountListEmptyException when no categories with task counts are found.
     * 
     * @param e the exception thrown when the category list with task counts is empty
     * @return ResponseEntity containing the error response with HTTP status NOT_FOUND
     */
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleCategoryWithTaskCountListEmptyException(CategoryWithTaskCountListEmptyException e) {
        ErrorResponse e1 = new ErrorResponse();
        e1.setCode(e.getCode());
        e1.setMessage(e.getMessage());

        return new ResponseEntity<ErrorResponse>(e1, HttpStatus.NOT_FOUND);
    }

    /**
     * Handles DeleteCategoryFailsException when a category deletion fails.
     * 
     * @param e the exception thrown when a category deletion operation fails
     * @return ResponseEntity containing the error response with HTTP status NOT_FOUND
     */
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleDeleteCategoryFailsException(DeleteCategoryFailsException e) {
        ErrorResponse e1 = new ErrorResponse();
        e1.setCode(e.getCode());
        e1.setMessage(e.getMessage());

        return new ResponseEntity<ErrorResponse>(e1, HttpStatus.NOT_FOUND);
    }

    /**
     * Handles UpdateCategoryFailsException when a category update operation fails.
     * 
     * @param e the exception thrown when a category update operation fails
     * @return ResponseEntity containing the error response with HTTP status NOT_FOUND
     */
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleUpdateCategoryFailsException(UpdateCategoryFailsException e) {
        ErrorResponse e1 = new ErrorResponse();
        e1.setCode(e.getCode());
        e1.setMessage(e.getMessage());

        return new ResponseEntity<ErrorResponse>(e1, HttpStatus.NOT_FOUND);
    }
}

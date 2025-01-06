package com.example.demo.GlobalExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.Exception.DeleteCommentFailsException;
import com.example.demo.Exception.ErrorResponse;
import com.example.demo.Exception.PostNewCommentFailsException;
import com.example.demo.Exception.UpdateCommentFailsException;

/**
 * Global Exception Handler for handling exceptions related to Comment operations.
 * Provides centralized exception handling for comment-related failures.
 */
@ControllerAdvice
public class CommentGlobalExceptionHandler {

    /**
     * Handles PostNewCommentFailsException when adding a new comment fails.
     * 
     * @param e the exception thrown when posting a new comment fails
     * @return ResponseEntity containing the error response with HTTP status INTERNAL_SERVER_ERROR
     */
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handlePostNewCommentFailsException(PostNewCommentFailsException e) {
        ErrorResponse e1 = new ErrorResponse();
        e1.setCode(e.getCode());
        e1.setMessage(e.getMessage());

        return new ResponseEntity<ErrorResponse>(e1, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * Handles UpdateCommentFailsException when updating an existing comment fails.
     * 
     * @param e the exception thrown when updating a comment fails
     * @return ResponseEntity containing the error response with HTTP status INTERNAL_SERVER_ERROR
     */
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleUpdateCommentFailsException(UpdateCommentFailsException e) {
        ErrorResponse e1 = new ErrorResponse();
        e1.setCode(e.getCode());
        e1.setMessage(e.getMessage());

        return new ResponseEntity<ErrorResponse>(e1, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * Handles DeleteCommentFailsException when deleting a comment fails.
     * 
     * @param e the exception thrown when deleting a comment fails
     * @return ResponseEntity containing the error response with HTTP status INTERNAL_SERVER_ERROR
     */
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> HandleDeleteCommentFailsException(DeleteCommentFailsException e) {
        ErrorResponse e1 = new ErrorResponse();
        e1.setCode(e.getCode());
        e1.setMessage(e.getMessage());

        return new ResponseEntity<ErrorResponse>(e1, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

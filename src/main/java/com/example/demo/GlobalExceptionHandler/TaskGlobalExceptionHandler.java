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

/**
 * Global Exception Handler for handling exceptions related to Task operations.
 * Centralizes exception handling for task-related failures.
 */
@ControllerAdvice
public class TaskGlobalExceptionHandler {

    /**
     * Handles TasksByPriorityAndStatusListEmptyException when no tasks are found for the given priority and status.
     * 
     * @param e the exception thrown when the task list is empty for the specified priority and status
     * @return ResponseEntity containing the error response with HTTP status NOT_FOUND
     */
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleTasksByPriorityAndStatusListEmptyException(TasksByPriorityAndStatusListEmptyException e) {
        ErrorResponse e1 = new ErrorResponse();
        e1.setCode(e.getCode());
        e1.setMessage(e.getMessage());

        return new ResponseEntity<ErrorResponse>(e1, HttpStatus.NOT_FOUND);
    }

    /**
     * Handles TasksDueSoonListEmptyException when no tasks are found that are due soon.
     * 
     * @param e the exception thrown when the list of due soon tasks is empty
     * @return ResponseEntity containing the error response with HTTP status NOT_FOUND
     */
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleTasksDueSoonListEmptyException(TasksDueSoonListEmptyException e) {
        ErrorResponse e1 = new ErrorResponse();
        e1.setCode(e.getCode());
        e1.setMessage(e.getMessage());

        return new ResponseEntity<ErrorResponse>(e1, HttpStatus.NOT_FOUND);
    }

    /**
     * Handles TasksByUserIDAndStatusEmptyListException when no tasks are found for the given user ID and status.
     * 
     * @param e the exception thrown when the task list is empty for the specified user ID and status
     * @return ResponseEntity containing the error response with HTTP status NOT_FOUND
     */
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleTasksByUserIDAndStatusEmptyListException(TasksByUserIDAndStatusEmptyListException e) {
        ErrorResponse e1 = new ErrorResponse();
        e1.setCode(e.getCode());
        e1.setMessage(e.getMessage());

        return new ResponseEntity<ErrorResponse>(e1, HttpStatus.NOT_FOUND);
    }

}

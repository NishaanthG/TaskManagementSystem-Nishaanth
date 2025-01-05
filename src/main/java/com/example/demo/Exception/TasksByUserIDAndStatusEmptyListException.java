package com.example.demo.Exception;

public class TasksByUserIDAndStatusEmptyListException extends RuntimeException{
	
    private String code;
	
	public TasksByUserIDAndStatusEmptyListException(String code , String message) {
		super(message);
		this.code=code;
	}
	
	public String getCode() {
        return code;
    }

}

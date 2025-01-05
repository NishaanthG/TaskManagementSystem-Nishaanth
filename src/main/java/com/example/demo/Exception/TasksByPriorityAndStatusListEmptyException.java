package com.example.demo.Exception;

public class TasksByPriorityAndStatusListEmptyException extends RuntimeException{
	
    private String code;
	
	public TasksByPriorityAndStatusListEmptyException(String code , String message) {
		super(message);
		this.code=code;
	}
	
	public String getCode() {
        return code;
    }

}

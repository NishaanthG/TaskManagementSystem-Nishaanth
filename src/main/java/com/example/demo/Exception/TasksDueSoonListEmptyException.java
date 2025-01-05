package com.example.demo.Exception;

public class TasksDueSoonListEmptyException extends RuntimeException{
	
    private String code;
	
	public TasksDueSoonListEmptyException(String code , String message) {
		super(message);
		this.code=code;
	}
	
	public String getCode() {
        return code;
    }

}

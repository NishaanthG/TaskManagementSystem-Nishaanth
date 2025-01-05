package com.example.demo.Exception;

public class UpdateCategoryFailsException extends RuntimeException{
	
    private String code;
	
	public UpdateCategoryFailsException(String code , String message) {
		super(message);
		this.code=code;
	}
	
	public String getCode() {
        return code;
    }
	
}

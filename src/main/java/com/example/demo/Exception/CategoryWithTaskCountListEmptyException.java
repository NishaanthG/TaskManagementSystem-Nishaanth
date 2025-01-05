package com.example.demo.Exception;

public class CategoryWithTaskCountListEmptyException extends RuntimeException{
	
    private String code;
	
	public CategoryWithTaskCountListEmptyException(String code , String message) {
		super(message);
		this.code=code;
	}
	
	public String getCode() {
        return code;
    }


}

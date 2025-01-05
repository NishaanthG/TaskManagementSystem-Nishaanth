package com.example.demo.Exception;

public class CategoryListEmptyException extends RuntimeException{
	
    private String code;
	
	public CategoryListEmptyException(String code , String message) {
		super(message);
		this.code=code;
	}
	
	public String getCode() {
        return code;
    }

}

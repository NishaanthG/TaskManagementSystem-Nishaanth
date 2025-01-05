package com.example.demo.Exception;

public class DeleteCategoryFailsException extends RuntimeException{
	
    private String code;
	
	public DeleteCategoryFailsException(String code , String message) {
		super(message);
		this.code=code;
	}
	
	public String getCode() {
        return code;
    }


}

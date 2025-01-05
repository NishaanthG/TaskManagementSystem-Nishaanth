package com.example.demo.Exception;

public class categoryObjectNotFoundException extends RuntimeException{
	
    private String code;
	
	public categoryObjectNotFoundException(String code , String message) {
		super(message);
		this.code=code;
	}
	
	public String getCode() {
        return code;
    }


}

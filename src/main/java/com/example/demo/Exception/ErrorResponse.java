package com.example.demo.Exception;

public class ErrorResponse {
	
	String code;
	String message;
	
	public ErrorResponse(String code, String message) {
		super();
		this.code = code;
		this.message = message;
	}
	public ErrorResponse() {
		super();
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}

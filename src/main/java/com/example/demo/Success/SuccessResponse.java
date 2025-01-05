package com.example.demo.Success;

public class SuccessResponse {
	
	String code;
	String message;
	
	public SuccessResponse(String code, String message) {
		super();
		this.code = code;
		this.message = message;
	}
	public SuccessResponse() {
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

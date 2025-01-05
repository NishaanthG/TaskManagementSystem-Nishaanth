package com.example.demo.Exception;

public class UpdateCommentFailsException extends RuntimeException{
	
	private String code;

	public UpdateCommentFailsException(String code , String Message){
		super(Message);
		this.code = code;
	}
	
	public String getCode() {
        return code;
    }

}

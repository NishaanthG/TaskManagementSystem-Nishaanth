package com.example.demo.Exception;

public class DeleteCommentFailsException extends RuntimeException{
	
	private String code;
	
	public DeleteCommentFailsException(String code , String message) {
		super(message);
		this.code=code;
	}
	
	public String getCode() {
        return code;
    }

}

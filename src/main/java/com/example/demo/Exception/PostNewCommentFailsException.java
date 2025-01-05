package com.example.demo.Exception;

public class PostNewCommentFailsException extends RuntimeException{
	
	private String code;

	public PostNewCommentFailsException(String code , String Message){
		super(Message);
		this.code = code;
	}
	
	public String getCode() {
        return code;
    }

}

package com.example.demo.dto;

import java.time.LocalDateTime;

public class NotificationDto {

	private String text;
	private int userID;
	
	public NotificationDto(String text,int userID) {
		super();
		this.text = text;
		this.userID = userID;
	}

	public NotificationDto() {
		super();
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}
	
	
	
	
	

}

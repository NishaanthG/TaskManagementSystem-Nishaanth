package com.example.demo.dto;

public class AttachmentDto {
	
	private String fileName;
	private String filePath;
	private int taskID;
	
	public AttachmentDto(String fileName, String filePath, int taskID) {
		this.fileName = fileName;
		this.filePath = filePath;
		this.taskID = taskID;
	}
	
	public AttachmentDto() {
		super();
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public int getTaskID() {
		return taskID;
	}

	public void setTaskID(int taskID) {
		this.taskID = taskID;
	}
	
}

package com.example.demo.dto;

public class CommentDTO {
    private String text;
    private int taskID; 
    private int userID; 

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getTaskID() {
        return taskID;
    }

    public void setTaskID(int taskID) {
        this.taskID = taskID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
}

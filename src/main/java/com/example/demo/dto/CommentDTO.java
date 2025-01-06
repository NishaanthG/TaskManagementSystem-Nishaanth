package com.example.demo.dto;

/**
 * Data Transfer Object (DTO) class representing a comment.
 * This class is used for transferring comment data, including the text of the comment,
 * associated task ID, and the user ID who posted the comment.
 */
public class CommentDTO {
    
    /** The text content of the comment. */
    private String text;
    
    /** The ID of the task associated with the comment. */
    private int taskID;
    
    /** The ID of the user who posted the comment. */
    private int userID;

    /**
     * Gets the text content of the comment.
     * 
     * @return The text of the comment.
     */
    public String getText() {
        return text;
    }

    /**
     * Sets the text content of the comment.
     * 
     * @param text The text of the comment to set.
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * Gets the task ID associated with the comment.
     * 
     * @return The task ID.
     */
    public int getTaskID() {
        return taskID;
    }

    /**
     * Sets the task ID associated with the comment.
     * 
     * @param taskID The task ID to set.
     */
    public void setTaskID(int taskID) {
        this.taskID = taskID;
    }

    /**
     * Gets the user ID who posted the comment.
     * 
     * @return The user ID.
     */
    public int getUserID() {
        return userID;
    }

    /**
     * Sets the user ID who posted the comment.
     * 
     * @param userID The user ID to set.
     */
    public void setUserID(int userID) {
        this.userID = userID;
    }
}

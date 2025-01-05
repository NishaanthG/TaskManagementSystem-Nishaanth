package com.example.demo.Model;

import java.io.Serializable;

import jakarta.persistence.Embeddable;

/**
 * Represents the composite key for the TaskCategory entity.
 * This class is marked as embeddable and implements Serializable.
 */
@Embeddable
public class TaskCategoryID implements Serializable{
	
	/**
     * The unique identifier of the task in the association.
     */
	private int taskID;
	
	 /**
     * The unique identifier of the category in the association.
     */
	private int categoryID;
	
	/**
     * Constructs a TaskCategoryID with the specified task and category IDs.
     *
     * @param taskID     the unique identifier for the task
     * @param categoryID the unique identifier for the category
     */
	public TaskCategoryID(int task, int category) {
		this.taskID = task;
		this.categoryID = category;
	}

	 /**
     * Default constructor for the TaskCategoryID class.
     */
	public TaskCategoryID() {
		
	}

	 /**
     * Gets the unique identifier of the task in the association.
     *
     * @return the task ID
     */
	public int getTask() {
		return taskID;
	}

	/**
     * Sets the unique identifier of the task in the association.
     *
     * @param taskID the task ID to set
     */
	public void setTask(int task) {
		this.taskID = task;
	}

	 /**
     * Gets the unique identifier of the category in the association.
     *
     * @return the category ID
     */
	public int getCategory() {
		return categoryID;
	}

	/**
     * Sets the unique identifier of the category in the association.
     *
     * @param categoryID the category ID to set
     */
	public void setCategory(int category) {
		this.categoryID = category;
	}

}

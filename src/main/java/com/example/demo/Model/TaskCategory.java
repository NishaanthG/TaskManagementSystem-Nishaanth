package com.example.demo.Model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * Represents the association between tasks and categories.
 * The entity is mapped to the "TaskCategory" table in the database and uses a composite key.
 */
@Entity
@Table(name = "TaskCategory")
public class TaskCategory {

	 /**
     * Composite primary key for the TaskCategory entity.
     */
	@EmbeddedId
	private TaskCategoryID id;
	
	/**
     * The task associated with this TaskCategory.
     * Represented as a many-to-one relationship.
     */
	@ManyToOne
	@JoinColumn(name = "taskID" , insertable=false, updatable=false )
	private Task task;
	
	/**
     * The category associated with this TaskCategory.
     * Represented as a many-to-one relationship.
     */
	@ManyToOne
	@JoinColumn(name = "categoryID" , insertable=false, updatable=false)
	private Category category;

	/**
     * Constructs a TaskCategory with the specified composite key, task, and category.
     *
     * @param id       the composite key representing the association
     * @param task     the task associated with the category
     * @param category the category associated with the task
     */
	public TaskCategory(TaskCategoryID id, Task task, Category category) {
		this.id = id;
		this.task = task;
		this.category = category;
	}

	 /**
     * Default constructor for the TaskCategory class.
     */
	public TaskCategory() {
		super();
	}

	/**
     * Gets the composite key for this TaskCategory.
     *
     * @return the composite key
     */
	public TaskCategoryID getId() {
		return id;
	}

	 /**
     * Sets the composite key for this TaskCategory.
     *
     * @param id the composite key to set
     */
	public void setId(TaskCategoryID id) {
		this.id = id;
	}

	 /**
     * Gets the task associated with this TaskCategory.
     *
     * @return the associated task
     */
	public Task getTask() {
		return task;
	}

	 /**
     * Sets the task associated with this TaskCategory.
     *
     * @param task the task to associate
     */
	public void setTask(Task task) {
		this.task = task;
	}

	/**
     * Gets the category associated with this TaskCategory.
     *
     * @return the associated category
     */
	public Category getCategory() {
		return category;
	}

	/**
     * Sets the category associated with this TaskCategory.
     *
     * @param category the category to associate
     */
	public void setCategory(Category category) {
		this.category = category;
	}
	
}

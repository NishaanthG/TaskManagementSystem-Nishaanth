package com.example.demo.Model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CollectionId;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * Represents a comment entity associated with a task and a user.
 * The entity is mapped to the "Comment" table in the database.
 */
@Entity
@Table(name = "Comment")
public class Comment {
	
	/**
     * Unique identifier for the comment.
     * Auto-generated using the identity strategy.
     */
	@Id
	@Column(name = "commentid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int commentID;
	
	 /**
     * Text content of the comment. Cannot be null or blank.
     */
	@Column(name = "text" , nullable = false)
	@NotBlank(message = "Commet text cannot be blank")
	private String text;
	
	 /**
     * Timestamp for when the comment was created. Cannot be null.
     */
	@Column(name = "createdat")
	private LocalDateTime createdAt;
	
	 /**
     * Task associated with the comment.
     */
	@ManyToOne
	@JoinColumn(name = "TaskID")
	@JsonIgnore
	private Task task;
	
	/**
     * User who created the comment.
     */
	@ManyToOne
	@JoinColumn(name = "UserID")
	@JsonIgnore
	private User user;

	 /**
     * Default constructor for the Comment class.
     */
	public Comment() {
		
	}

	/**
     * Constructs a Comment with the specified text, creation timestamp, task, and user.
     *
     * @param text - the text content of the comment
     * @param createdAt - the timestamp when the comment was created
     * @param task - the task associated with the comment
     * @param user - the user who created the comment
     */
	public Comment(String text, LocalDateTime createdAt, Task task, User user) {
		this.text = text;
		this.createdAt = createdAt;
		this.task = task;
		this.user = user;
	}
	
	/**
     * Gets the unique identifier of the comment.
     *
     * @return the comment ID
     */
	public int getCommentID() {
		return commentID;
	}

	/**
     * Gets the text content of the comment.
     *
     * @return the text content
     */
	public String getText() {
		return text;
	}

	/**
     * Sets the text content of the comment.
     *
     * @param text the text content to set
     */
	public void setText(String text) {
		this.text = text;
	}

	 /**
     * Gets the timestamp when the comment was created.
     *
     * @return the creation timestamp
     */
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	/**
     * Sets the timestamp when the comment was created.
     *
     * @param createdAt the creation timestamp to set
     */
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	 /**
     * Gets the task associated with the comment.
     *
     * @return the associated task
     */
	public Task getTask() {
		return task;
	}

	/**
     * Sets the task associated with the comment.
     *
     * @param task the associated task to set
     */
	public void setTask(Task task) {
		this.task = task;
	}

	/**
     * Gets the user who created the comment.
     *
     * @return the user
     */
	public User getUser() {
		return user;
	}

	/**
     * Sets the user who created the comment.
     *
     * @param user the user to set
     */
	public void setUser(User user) {
		this.user = user;
	}
	

}

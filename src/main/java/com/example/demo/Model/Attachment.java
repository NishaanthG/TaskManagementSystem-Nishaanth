package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


/**
 * Represents an attachment entity with a file name, file path, and associated task.
 * The entity is mapped to the "Attachment" table in the database.
 */
@Entity
@Table(name = "Attachment")
public class Attachment {
	
	/**
     * Unique identifier for the attachment.
     * Auto-generated using the identity strategy.
     */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "attachmentid")
	private int attachmentID;
	
	 /**
     * Name of the file. Cannot be null or blank.
     */
	@Column(name = "filename" , nullable = false)
	@NotBlank(message = "Filename cannot be blank")
	@Size(max = 50 , message = "Filename cannot exceed 20 Characters")
	private String fileName;
	
	 /**
     * Path to the file. Cannot be null or blank.
     */
	@Column(name = "filepath")
	@NotBlank(message = "File path Cannot be blank")
	private String filePath;
	
	/**
     * The task associated with the attachment.
     * Mapped as a many-to-one relationship.
     */
	@ManyToOne
	@JoinColumn(name = "TaskID")
	@NotNull(message = "Task Cannot be Null")
	@JsonIgnore
	private Task task;

	/**
     * Default constructor for the Attachment class.
     */
	public Attachment() {
	
	}

	/**
     * Constructs an Attachment with the specified file name, file path, and associated task.
     *
     * @param fileName - the name of the file
     * @param filePath - the path to the file
     * @param task - the task associated with the attachment
     */
	public Attachment(String fileName, String filePath, Task task) {
		this.fileName = fileName;
		this.filePath = filePath;
		this.task = task;
	}
	
	/**
     * Gets the unique identifier of the attachment.
     *
     * @return the attachment ID
     */
	public int getAttachmentID() {
		return attachmentID;
	}

	/**
     * Gets the name of the file.
     *
     * @return the file name
     */
	public String getFileName() {
		return fileName;
	}

	/**
     * Sets the name of the file.
     *
     * @param fileName - the file name to set
     */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
     * Gets the path to the file.
     *
     * @return the file path
     */
	public String getFilePath() {
		return filePath;
	}

	/**
     * Sets the path to the file.
     *
     * @param filePath - the file path to set
     */
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	/**
     * Gets the task associated with the attachment.
     *
     * @return the associated task
     */
	public Task getTask() {
		return task;
	}

	 /**
     * Sets the task associated with the attachment.
     *
     * @param task the task to associate with this attachment
     */
	public void setTask(Task task) {
		this.task = task;
	}

}

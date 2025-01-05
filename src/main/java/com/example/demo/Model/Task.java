package com.example.demo.Model;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.hibernate.annotations.CollectionId;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * Entity representing a Task in the system.
 * A Task is associated with a project, a user, and may have comments, attachments, and categories.
 */
@Entity
@Table(name = "Task")
public class Task {
	
	/**
     * Unique identifier for the task.
     * Auto-generated using the identity strategy.
     */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "taskid")
	private int taskID;
	
	/**
     * Name of the task. Cannot be null or blank.
     */
	@NotBlank(message = "Task name is mandatory")
	@Size(max = 100 , message = "Task name cannot exceed 100 characters")
	@Column(name = "taskname" , nullable = false)
	private String taskName;
	
	/**
     * Description of the task. Cannot be null or blank.
     */
	@NotBlank(message = "Task description is mandatory")
	@Size(max = 500 , message = "Description cannot exceed 500 characters")
	@Column(name = "description" , nullable = false)
	private String description;
	
	/**
     * Due date of the task. Must be a future or present date.
     */
	@NotNull(message = "Due date is mandatory")
	@FutureOrPresent(message = "Due date must be today or a future date")
	@Column(name = "duedate" , nullable = false)
	private LocalDate dueDate;
	
	 /**
     * Priority of the task. Cannot be null or blank.
     */
	@NotBlank(message = "Priority is mandatory")
	@Size(max = 20 , message = "Priority cannot exceed 20 characters")
	@Column(name = "priority" , nullable = false)
	private String priority;
	
	/**
     * Current status of the task. Cannot be null or blank.
     */
    @NotBlank(message = "Status is mandatory")
    @Size(max = 20, message = "Status cannot exceed 20 characters")
	@Column(name = "status" , nullable = false)
	private String status;
	
    /**
     * The project to which the task belongs. Represents a many-to-one relationship.
     */
	@ManyToOne
	@JoinColumn(name = "projectID")
	@JsonIgnore
	private Project project;
	
	/**
     * The user responsible for the task. Represents a many-to-one relationship.
     */
	@ManyToOne
	@JoinColumn(name = "userID")
	@JsonIgnore
	private User user;
	
	/**
     * List of comments associated with the task. Represents a one-to-many relationship.
     */
	@OneToMany(mappedBy = "task" , cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Comment> comments;
	
	 /**
     * List of attachments related to the task. Represents a one-to-many relationship.
     */
	@OneToMany(mappedBy = "task" , cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Attachment> attachments;
	
	/**
     * List of categories linked to the task. Represents a one-to-many relationship.
     */
	@OneToMany(mappedBy = "task" , cascade = CascadeType.ALL)
	@JsonIgnore
	private List<TaskCategory> taskCategories;

	/**
     * Constructs a Task with the specified attributes.
     *
     * @param taskName        the name of the task
     * @param description     the description of the task
     * @param dueDate         the due date of the task
     * @param priority        the priority of the task
     * @param status          the current status of the task
     * @param project         the project associated with the task
     * @param user            the user responsible for the task
     * @param comments        the list of comments associated with the task
     * @param attachments     the list of attachments associated with the task
     * @param taskCategories  the list of categories linked to the task
     */
	public Task(String taskName, String description, LocalDate dueDate, String priority, String status,
			Project project, User user, List<Comment> comments, List<Attachment> attachments,
			List<TaskCategory> taskCategories) {
		this.taskName = taskName;
		this.description = description;
		this.dueDate = dueDate;
		this.priority = priority;
		this.status = status;
		this.project = project;
		this.user = user;
		this.comments = comments;
		this.attachments = attachments;
		this.taskCategories = taskCategories;
	}

	 /**
     * Default constructor for the Task class.
     */
	public Task() {
		
	}

	  /**
     * Gets the unique identifier of the task.
     *
     * @return the task ID
     */
	public int getTaskID() {
		return taskID;
	}
	
	
	public void setTaskID(int TaskID) {
		this.taskID = taskID;
	}

	 /**
     * Gets the name of the task.
     *
     * @return the task name
     */
	public String getTaskName() {
		return taskName;
	}


    /**
     * Sets the name of the task.
     *
     * @param taskName the task name to set
     */
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	/**
     * Gets the description of the task.
     *
     * @return the task description
     */
	public String getDescription() {
		return description;
	}

	/**
     * Sets the description of the task.
     *
     * @param description the task description to set
     */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
     * Gets the due date of the task.
     *
     * @return the due date
     */
	public LocalDate getDueDate() {
		return dueDate;
	}

	/**
     * Sets the due date of the task.
     *
     * @param dueDate the due date to set
     */
	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	/**
     * Gets the priority of the task.
     *
     * @return the task priority
     */
	public String getPriority() {
		return priority;
	}

	 /**
     * Sets the priority of the task.
     *
     * @param priority the task priority to set
     */
	public void setPriority(String priority) {
		this.priority = priority;
	}

	 /**
     * Gets the current status of the task.
     *
     * @return the task status
     */
	public String getStatus() {
		return status;
	}

	/**
     * Sets the current status of the task.
     *
     * @param status the task status to set
     */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
     * Gets the project associated with the task.
     *
     * @return the associated project
     */
	public Project getProject() {
		return project;
	}

	/**
     * Sets the project associated with the task.
     *
     * @param project the project to associate
     */
	public void setProject(Project project) {
		this.project = project;
	}

	/**
     * Gets the user responsible for the task.
     *
     * @return the responsible user
     */
	public User getUser() {
		return user;
	}

	/**
     * Sets the user responsible for the task.
     *
     * @param user the user to associate
     */
	public void setUser(User user) {
		this.user = user;
	}

	 /**
     * Gets the list of comments associated with the task.
     *
     * @return the list of associated comments
     */
	public List<Comment> getComments() {
		return comments;
	}

	 /**
     * Sets the list of comments associated with the task.
     *
     * @param comments the list of comments to associate
     */
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	/**
     * Gets the list of attachments related to the task.
     *
     * @return the list of related attachments
     */
	public List<Attachment> getAttachments() {
		return attachments;
	}

    /**
     * Sets the list of attachments related to the task.
     *
     * @param attachments the list of attachments to associate
     */
	public void setAttachments(List<Attachment> attachments) {
		this.attachments = attachments;
	}

	/**
     * Gets the list of categories linked to the task.
     *
     * @return the list of linked categories
     */
	public List<TaskCategory> getTaskCategories() {
		return taskCategories;
	}

	 /**
     * Sets the list of categories linked to the task.
     *
     * @param taskCategories the list of categories to associate
     */
	public void setTaskCategories(List<TaskCategory> taskCategories) {
		this.taskCategories = taskCategories;
	}
	
}

package com.example.demo.Model;
import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * Represents a project entity managed by a user, containing details about tasks and timelines.
 * This entity is mapped to the "Project" table in the database.
 */
@Entity
@Table(name = "Project")
public class Project {
	
	/**
     * Unique identifier for the project.
     * Auto-generated using the identity strategy.
     */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "projectid")
	private int projectID;
	
	/**
     * Name of the project. Cannot be null or blank.
     */
	@Column(name = "projectname" , nullable = false)
	@NotBlank(message = "Project name cannot be blank")
	@Size(max = 50 , message = "Project name cannot exceed 20 characters")
	private String projectName;
	
	/**
     * Description of the project. Cannot be null or blank.
     */
	@Column(name = "description" , nullable = false)
	@NotBlank(message = "Description cannot be blank")
	private String description;
	
	/**
     * Start date of the project. Cannot be null.
     */
	@Column(name = "startdate" , nullable = false)
	@NotNull(message = "Start date cannot be null")
	private LocalDate startDate;
	
	 /**
     * End date of the project. Must be after the start date.
     */
	@Column(name = "enddate" , nullable = false)
	@NotNull(message = "End date cannot be null")
	@FutureOrPresent(message = "End date must be in the present or future")
	private LocalDate endDate;
	
	 /**
     * User associated with the project.
     */
	@ManyToOne
	@JoinColumn(name = "UserID")
	@JsonIgnore
	private User user;
	
	/**
     * List of tasks associated with the project.
     * Managed with a one-to-many relationship.
     */
	@OneToMany(mappedBy = "project" , cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Task> tasks;

	 /**
     * Constructs a Project with the specified details.
     *
     * @param projectName Name of the project
     * @param description Description of the project
     * @param startDate   Start date of the project
     * @param endDate     End date of the project
     * @param user        User associated with the project
     * @param tasks       List of tasks associated with the project
     */
	public Project(String projectName, String description, LocalDate startDate, LocalDate endDate, User user,List<Task> tasks) {
		this.projectName = projectName;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		this.user = user;
		this.tasks = tasks;
	}

	/**
     * Default constructor for the Project class.
     */
	public Project() {
	
	}

	/**
     * Gets the unique identifier of the project.
     *
     * @return the project ID
     */
	public int getProjectID() {
		return projectID;
	}

	 /**
     * Gets the name of the project.
     *
     * @return the project name
     */
	public String getProjectName() {
		return projectName;
	}

	  /**
     * Sets the name of the project.
     *
     * @param projectName the name to set
     */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	/**
     * Gets the description of the project.
     *
     * @return the project description
     */
	public String getDescription() {
		return description;
	}

	/**
     * Sets the description of the project.
     *
     * @param description the description to set
     */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
     * Gets the start date of the project.
     *
     * @return the start date
     */
	public LocalDate getStartDate() {
		return startDate;
	}

	/**
     * Sets the start date of the project.
     *
     * @param startDate the start date to set
     */
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	/**
     * Gets the end date of the project.
     *
     * @return the end date
     */
	public LocalDate getEndDate() {
		return endDate;
	}

	/**
     * Sets the end date of the project. Must be after the start date.
     *
     * @param endDate the end date to set
     */
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	/**
     * Gets the user associated with the project.
     *
     * @return the associated user
     */
	public User getUser() {
		return user;
	}

	 /**
     * Sets the user associated with the project.
     *
     * @param user the user to set
     */
	public void setUser(User user) {
		this.user = user;
	}

	 /**
     * Gets the list of tasks associated with the project.
     *
     * @return the list of tasks
     */
	public List<Task> getTasks() {
		return tasks;
	}

	 /**
     * Sets the list of tasks associated with the project.
     *
     * @param tasks the list of tasks to set
     */
	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
	
}

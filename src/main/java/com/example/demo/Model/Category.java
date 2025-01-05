package com.example.demo.Model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * Represents a category entity with a name and associated task categories.
 * The entity is mapped to the "Category" table in the database.
 */
@Entity
@Table(name = "Category")
public class Category {
	
	/**
     * Unique identifier for the category.
     * Auto-generated using the identity strategy.
     */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "categoryid")
	private int categoryID;
	
	/**
     * Name of the category. Cannot be null or blank.
     */
	@Column(name = "categoryname")
	@NotBlank(message = "Category name cannot be blank")
	@Size(max = 20 , message = "Category name cannot exceed 20 characters")
	private String categoryName;

	/**
     * List of task categories associated with this category.
     * Represented as a one-to-many relationship.
     */
	@OneToMany(mappedBy = "category" , cascade = CascadeType.ALL)
	@JsonIgnore
	private List<TaskCategory> taskCategories;
	
	/**
     * Constructs a Category with the specified name and associated task categories.
     *
     * @param categoryName - the name of the category
     * @param taskCategories - the list of associated task categories
     */
	public Category(String categoryName, List<TaskCategory> taskCategories) {
		this.categoryName = categoryName;
		this.taskCategories = taskCategories;
	}

	/**
     * Default constructor for the Category class.
     */
	public Category() {

	}

	 /**
     * Gets the unique identifier of the category.
     *
     * @return the category ID
     */

	public int getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}

	/**
     * Gets the name of the category.
     *
     * @return the category name
     */
	public String getCategoryName() {
		return categoryName;
	}

	/**
     * Sets the name of the category.
     *
     * @param categoryName the category name to set
     */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	/**
     * Gets the list of task categories associated with this category.
     *
     * @return the list of associated task categories
     */
	public List<TaskCategory> getTaskCategories() {
		return taskCategories;
	}

	/**
     * Sets the list of task categories associated with this category.
     *
     * @param taskCategories the list of associated task categories
     */
	public void setTaskCategories(List<TaskCategory> taskCategories) {
		this.taskCategories = taskCategories;
	}
	
}
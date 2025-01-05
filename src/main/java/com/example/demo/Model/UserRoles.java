package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * Represents a mapping between a user and a user role.
 * The entity is mapped to the "UserRoles" table in the database.
 */
@Entity
@Table(name = "UserRoles")
public class UserRoles {
	
	/**
     * Composite key for the UserRoles entity.
     */
	@EmbeddedId
	private UserRolesID userrolesID;
	
	/**
     * The user associated with this role.
     * Represented as a many-to-one relationship.
     * Ignored during JSON serialization to avoid cyclic dependencies.
     */
	@ManyToOne
	@JoinColumn(name = "userID" , insertable=false, updatable=false)
	@JsonIgnore
	private User user;
	
	 /**
     * The role associated with this user.
     * Represented as a many-to-one relationship.
     */
	@ManyToOne
	@JoinColumn(name = "userRoleID" , insertable=false, updatable=false)
	private UserRole userRole;

	/**
     * Constructs a UserRoles entity with the specified composite key, user, and user role.
     *
     * @param userRolesID the composite key for the mapping
     * @param user        the user associated with the role
     * @param userRole    the role associated with the user
     */
	public UserRoles(UserRolesID id, User user, UserRole userRole) {
		this.userrolesID = id;
		this.user = user;
		this.userRole = userRole;
	}

	 /**
     * Default constructor for the UserRoles class.
     */
	public UserRoles() {
		super();
	}

	/**
     * Gets the composite key for the UserRoles entity.
     *
     * @return the composite key
     */
	public UserRolesID getId() {
		return userrolesID;
	}

	/**
     * Sets the composite key for the UserRoles entity.
     *
     * @param userRolesID the composite key to set
     */
	public void setId(UserRolesID id) {
		this.userrolesID = id;
	}

	/**
     * Gets the user associated with this role.
     *
     * @return the associated user
     */
	public User getUser() {
		return user;
	}

	/**
     * Sets the user associated with this role.
     *
     * @param user the user to associate with this role
     */
	public void setUser(User user) {
		this.user = user;
	}

	/**
     * Gets the role associated with this user.
     *
     * @return the associated role
     */
	public UserRole getUserRole() {
		return userRole;
	}

	/**
     * Sets the role associated with this user.
     *
     * @param userRole the role to associate with this user
     */
	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}

}

package com.example.demo.Model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

/**
 * Represents the composite primary key for the UserRoles entity.
 * This class is marked as embeddable for use in the UserRoles entity.
 */
@Embeddable
public class UserRolesID implements Serializable{
	
	/**
     * The ID of the user. 
     * Represents the foreign key reference to the User entity.
     */
	private int userID;
	
	 /**
     * The ID of the user role. 
     * Represents the foreign key reference to the UserRole entity.
     */
	private int userRoleID;

	/**
     * Default constructor for the UserRolesID class.
     */
	public UserRolesID() {
		
	}

	/**
     * Constructs a UserRolesID with the specified user ID and user role ID.
     *
     * @param userID     the ID of the user
     * @param userRoleID the ID of the user role
     */
	public UserRolesID(int userID, int userroleID) {
		this.userID = userID;
		this.userRoleID = userroleID;
	}

	/**
     * Gets the user ID.
     *
     * @return the user ID
     */
	public int getUserID() {
		return userID;
	}

	/**
     * Sets the user ID.
     *
     * @param userID the user ID to set
     */
	public void setUserID(int userID) {
		this.userID = userID;
	}

	 /**
     * Gets the user role ID.
     *
     * @return the user role ID
     */
	public int getUserroleID() {
		return userRoleID;
	}

	 /**
     * Sets the user role ID.
     *
     * @param userRoleID the user role ID to set
     */
	public void setUserroleID(int userroleID) {
		this.userRoleID = userroleID;
	}
	
	

}

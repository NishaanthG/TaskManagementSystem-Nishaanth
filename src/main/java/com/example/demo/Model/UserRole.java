package com.example.demo.Model;

import java.util.List;

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
 * Represents a user role entity with a role name and associated user roles.
 * The entity is mapped to the "UserRole" table in the database.
 */
@Entity
@Table(name = "UserRole")
public class UserRole {
	
	 /**
     * Unique identifier for the user role.
     * Auto-generated using the identity strategy.
     */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userroleid")
	private int userRoleID;
	
	 /**
     * Name of the user role. Cannot be null or blank.
     */
	@Column(name = "rolename" , nullable = false)
	@NotBlank(message = "Role name cannot be blank")
	@Size(max = 50, message = "Role name cannot exceed 50 characters")
	private String roleName;
	
	/**
     * List of user-role mappings associated with this user role.
     * Represented as a one-to-many relationship.
     */
	@OneToMany(mappedBy = "userRole" , cascade = CascadeType.ALL)
	private List<UserRoles> userRoles;

	/**
     * Constructs a UserRole with the specified role name and associated user roles.
     *
     * @param roleName   the name of the user role
     * @param userRoles  the list of associated user-role mappings
     */
	public UserRole(String roleName, List<UserRoles> userRoles) {
		this.roleName = roleName;
		this.userRoles = userRoles;
	}

	/**
     * Default constructor for the UserRole class.
     */
	public UserRole() {
		super();
	}

	 /**
     * Gets the unique identifier of the user role.
     *
     * @return the user role ID
     */
	public int getUserRoleID() {
		return userRoleID;
	}

	 /**
     * Gets the name of the user role.
     *
     * @return the role name
     */
	public String getRoleName() {
		return roleName;
	}

	/**
     * Sets the name of the user role.
     *
     * @param roleName the role name to set
     */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	 /**
     * Gets the list of user-role mappings associated with this user role.
     *
     * @return the list of associated user-role mappings
     */
	public List<UserRoles> getUserRoles() {
		return userRoles;
	}

	/**
     * Sets the list of user-role mappings associated with this user role.
     *
     * @param userRoles the list of associated user-role mappings
     */
	public void setUserRoles(List<UserRoles> userRoles) {
		this.userRoles = userRoles;
	}

}
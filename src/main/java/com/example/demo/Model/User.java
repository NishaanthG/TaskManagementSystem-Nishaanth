package com.example.demo.Model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * Represents a User entity in the system.
 * This entity contains details about users and their relationships with various entities like projects, tasks, comments, etc.
 */
@Entity
@Table(name = "User")
public class User {

    /**
     * The unique ID of the user.
     * Auto-generated using the IDENTITY strategy.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userid")
    private int userID;

    /**
     * The username of the user.
     * Must not be blank and must have a length between 3 and 20 characters.
     */
    @NotBlank(message = "Username is required.")
    @Size(min = 3, max = 20, message = "Username must be between 3 and 20 characters.")
    @Column(name = "username", nullable = false)
    private String username;

    /**
     * The password of the user.
     * Must not be blank and must have a length between 6 and 50 characters.
     */
    @NotBlank(message = "Password is required.")
    @Size(min = 6, max = 50, message = "Password must be between 6 and 50 characters.")
    @Column(name = "password", nullable = false)
    private String password;

    /**
     * The email of the user.
     * Must be a valid email format.
     */
    @NotBlank(message = "Email is required.")
    @Email(message = "Email should be valid.")
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    /**
     * The full name of the user.
     * Must not be blank and must have a length between 1 and 50 characters.
     */
    @NotBlank(message = "Full name is required.")
    @Size(max = 50, message = "Full name must be at most 50 characters.")
    @Column(name = "fullname", nullable = false)
    private String fullname;

    /**
     * The list of projects associated with the user.
     * This is a one-to-many relationship.
     */
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Project> projects;

    /**
     * The list of tasks assigned to the user.
     * This is a one-to-many relationship.
     */
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Task> tasks;

    /**
     * The list of comments made by the user.
     * This is a one-to-many relationship.
     */
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Comment> comments;

    /**
     * The list of notifications sent to the user.
     * This is a one-to-many relationship.
     */
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Notification> notifications;

    /**
     * The list of roles assigned to the user.
     * This is a one-to-many relationship.
     */
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<UserRoles> userRoles;

    /**
     * Default constructor for the User entity.
     */
    public User() {
        super();
    }

    /**
     * Constructs a User with the specified attributes and relationships.
     *
     * @param username      the username of the user
     * @param password      the password of the user
     * @param email         the email of the user
     * @param fullname      the full name of the user
     * @param projects      the list of projects associated with the user
     * @param tasks         the list of tasks assigned to the user
     * @param comments      the list of comments made by the user
     * @param notifications the list of notifications sent to the user
     * @param userRoles     the list of roles assigned to the user
     */
    public User(String username, String password, String email, String fullname, List<Project> projects,
            List<Task> tasks, List<Comment> comments, List<Notification> notifications, List<UserRoles> userRoles) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.fullname = fullname;
        this.projects = projects;
        this.tasks = tasks;
        this.comments = comments;
        this.notifications = notifications;
        this.userRoles = userRoles;
    }

    
    /**
     * Gets the unique ID of the user.
     *
     * @return the user ID.
     */
    public int getUserID() {
        return userID;
    }
    
    public void setUserId(int userID) {
    	this.userID = userID;
    }

    /**
     * Gets the username of the user.
     *
     * @return the username.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username of the user.
     *
     * @param username the new username.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the password of the user.
     *
     * @return the password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password of the user.
     *
     * @param password the new password.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the email of the user.
     *
     * @return the email.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email of the user.
     *
     * @param email the new email.
     */

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the full name of the user.
     *
     * @return the full name.
     */
    public String getFullname() {
        return fullname;
    }

    /**
     * Sets the full name of the user.
     *
     * @param fullname the new full name.
     */
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    /**
     * Gets the list of projects associated with the user.
     *
     * @return the list of projects.
     */
    public List<Project> getProjects() {
        return projects;
    }

    /**
     * Sets the list of projects associated with the user.
     *
     * @param projects the new list of projects.
     */

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    /**
     * Gets the list of tasks assigned to the user.
     *
     * @return the list of tasks.
     */
    public List<Task> getTasks() {
        return tasks;
    }

    /**
     * Sets the list of tasks assigned to the user.
     *
     * @param tasks the new list of tasks.
     */
    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    /**
     * Gets the list of comments made by the user.
     *
     * @return the list of comments.
     */
    public List<Comment> getComments() {
        return comments;
    }

    /**
     * Sets the list of comments made by the user.
     *
     * @param comments the new list of comments.
     */
    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    /**
     * Gets the list of notifications sent to the user.
     *
     * @return the list of notifications.
     */
    public List<Notification> getNotifications() {
        return notifications;
    }

    /**
     * Sets the list of notifications sent to the user.
     *
     * @param notifications the new list of notifications.
     */
    public void setNotifications(List<Notification> notifications) {
        this.notifications = notifications;
    }

    /**
     * Gets the list of roles assigned to the user.
     *
     * @return the list of user roles.
     */
    public List<UserRoles> getUserRoles() {
        return userRoles;
    }

    /**
     * Sets the list of roles assigned to the user.
     *
     * @param userRoles the new list of user roles.
     */
    public void setUserRoles(List<UserRoles> userRoles) {
        this.userRoles = userRoles;
    }
}

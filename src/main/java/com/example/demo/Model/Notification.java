package com.example.demo.Model;

import java.time.LocalDateTime;

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

/**
 * Represents a notification entity associated with a user.
 * The entity is mapped to the "Notification" table in the database.
 */
@Entity
@Table(name = "Notification")
public class Notification {
	
	/**
     * Unique identifier for the notification.
     * Auto-generated using the identity strategy.
     */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "notificationid")
	private int notificationID;
	
	 /**
     * Text content of the notification. Cannot be null or blank.
     */
	@Column(name = "text" , nullable = false)
	@NotBlank(message = "Notification text cannot be blank")
	private String text;
	
	/**
     * Timestamp for when the notification was created. Cannot be null.
     */
	@Column(name = "createdat" , nullable = false)
	private LocalDateTime createdAt;
	
	/**
     * User associated with the notification.
     */

	@ManyToOne
	@JoinColumn(name = "UserID")
	@JsonIgnore
	private User user;

	/**
     * Default constructor for the Notification class.
     */
	public Notification() {
		
	}

	 /**
     * Constructs a Notification with the specified text, creation timestamp, and user.
     *
     * @param text - the text content of the notification
     * @param createdAt - the timestamp when the notification was created
     * @param user - the user associated with the notification
     */
	public Notification(String text, LocalDateTime createdAt, User user) {
		this.text = text;
		this.createdAt = createdAt;
		this.user = user;
	}

	/**
     * Gets the unique identifier of the notification.
     *
     * @return the notification ID
     */
	public int getNotificationid() {
		return notificationID;
	}

	/**
     * Gets the text content of the notification.
     *
     * @return the text content
     */
	public String getText() {
		return text;
	}

	/**
     * Sets the text content of the notification.
     *
     * @param text the text content to set
     */
	public void setText(String text) {
		this.text = text;
	}

	 /**
     * Gets the timestamp when the notification was created.
     *
     * @return the creation timestamp
     */
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	/**
     * Sets the timestamp when the notification was created.
     *
     * @param createdAt the creation timestamp to set
     */
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	/**
     * Gets the user associated with the notification.
     *
     * @return the associated user
     */
	public User getUser() {
		return user;
	}

	/**
     * Sets the user associated with the notification.
     *
     * @param user the associated user to set
     */
	public void setUser(User user) {
		this.user = user;
	}

}

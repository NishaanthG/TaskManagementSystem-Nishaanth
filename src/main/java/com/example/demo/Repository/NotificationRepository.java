package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Notification;

/**
 * Repository interface for managing Notification entities.
 * Extends JpaRepository to provide CRUD operations and additional JPA functionalities.
 */
public interface NotificationRepository extends JpaRepository<Notification, Integer>{

}

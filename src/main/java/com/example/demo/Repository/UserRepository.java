package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.User;

/**
 * Repository interface for managing user entities.
 * Extends JpaRepository to provide CRUD operations and additional JPA functionalities.
 */
public interface UserRepository extends JpaRepository<User, Integer>{

}

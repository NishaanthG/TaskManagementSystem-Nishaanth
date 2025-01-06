package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.UserRole;

/**
 * Repository interface for managing userRole entities.
 * Extends JpaRepository to provide CRUD operations and additional JPA functionalities.
 */
public interface UserRoleRepository extends JpaRepository<UserRole, Integer>{

}

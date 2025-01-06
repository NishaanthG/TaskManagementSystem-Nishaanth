package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.UserRoles;
import com.example.demo.Model.UserRolesID;

/**
 * Repository interface for managing UserRoles entities.
 * Extends JpaRepository to provide CRUD operations and additional JPA functionalities.
 */
public interface UserRolesRepository extends JpaRepository<UserRoles, UserRolesID>{

}

package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.UserRoles;
import com.example.demo.Model.UserRolesID;

public interface UserRolesRepository extends JpaRepository<UserRoles, UserRolesID>{

}

package com.example.demo.Repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Task;
import com.example.demo.Model.User;

/**
 * Repository interface for managing task entities.
 * Extends JpaRepository to provide CRUD operations and additional JPA functionalities.
 */
public interface TaskRepository extends JpaRepository<Task, Integer>{
	
	/**
     * Retrieves a list of tasks based on their priority and status.
     * 
     * @param priority the priority of the tasks to filter by (e.g., "High", "Low").
     * @param status the status of the tasks to filter by (e.g., "Pending", "Completed").
     * @return a list of tasks that match the given priority and status.
     */
    public List<Task> findByPriorityAndStatus(String priority, String status);
}

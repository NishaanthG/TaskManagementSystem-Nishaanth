package com.example.demo.Service;

import java.util.List;

import com.example.demo.Model.Task;

/**
 * Service interface for managing Task entities.
 * Provides methods to perform operations such as retrieving tasks based on priority, status, due dates, and user associations.
 */
public interface TaskService {

    /**
     * Retrieves a list of tasks filtered by their priority and status.
     * 
     * @param priority the priority of the tasks to filter by (e.g., "High", "Low").
     * @param status the status of the tasks to filter by (e.g., "Pending", "Completed").
     * @return a list of tasks that match the specified priority and status.
     */
    public List<Task> getTasksByPriorityAndStatus(String priority, String status);

    /**
     * Retrieves a list of tasks that are due soon.
     * 
     * @return a list of tasks with upcoming due dates.
     */
    public List<Task> getDueSoonTasks();

    /**
     * Retrieves a list of tasks assigned to a specific user and filtered by status.
     * 
     * @param UserID the ID of the user to whom the tasks are assigned.
     * @param status the status of the tasks to filter by (e.g., "Pending", "Completed").
     * @return a list of tasks assigned to the specified user with the specified status.
     */
    public List<Task> getTasksByUserIDAndStatus(int UserID, String status);    

}


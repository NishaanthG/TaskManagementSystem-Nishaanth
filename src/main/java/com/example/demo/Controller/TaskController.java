package com.example.demo.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Task;
import com.example.demo.Service.TaskService;

/**
 * Rest Controller for managing tasks.
 * Provides endpoints for fetching tasks based on priority, status, and user.
 */
@RestController
public class TaskController {

    private static final Logger logger = LoggerFactory.getLogger(TaskController.class);

    @Autowired
    private TaskService ts;

    /**
     * Retrieves tasks filtered by priority and status.
     * 
     * @param priority the priority of the tasks (e.g., high, medium, low)
     * @param status the status of the tasks (e.g., pending, completed)
     * @return a list of tasks matching the given priority and status
     */
    @GetMapping("/api/tasks/priority/{priority}/status/{status}")
    public List<Task> getTasksbyPriorityAndStatus(@PathVariable String priority, @PathVariable String status) {
        logger.info("Fetching tasks with priority: {} and status: {}", priority, status);
        return ts.getTasksByPriorityAndStatus(priority, status);
    }

    /**
     * Retrieves tasks that are due soon.
     * 
     * @return a list of tasks that are nearing their due date
     */
    @GetMapping("/api/tasks/due-soon")
    public List<Task> getTasksThatAreDueSoon() {
        logger.info("Fetching tasks that are due soon");
        return ts.getDueSoonTasks();
    }

    /**
     * Retrieves tasks assigned to a specific user and filtered by status.
     * 
     * @param userId the ID of the user
     * @param status the status of the tasks (e.g., pending, completed)
     * @return a list of tasks assigned to the user with the given status
     */
    @GetMapping("/api/tasks/user/{userId}/status/{status}")
    public List<Task> getTasksByUserIDAndStatus(@PathVariable int userId, @PathVariable String status) {
        logger.info("Fetching tasks for user ID: {} with status: {}", userId, status);
        return ts.getTasksByUserIDAndStatus(userId, status);
    }
}

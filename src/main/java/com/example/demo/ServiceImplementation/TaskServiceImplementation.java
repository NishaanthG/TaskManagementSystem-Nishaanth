package com.example.demo.ServiceImplementation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Exception.TasksByPriorityAndStatusListEmptyException;
import com.example.demo.Exception.TasksByUserIDAndStatusEmptyListException;
import com.example.demo.Exception.TasksDueSoonListEmptyException;
import com.example.demo.Model.Task;
import com.example.demo.Model.User;
import com.example.demo.Repository.TaskRepository;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.TaskService;

/**
 * Implementation of the {@link TaskService} interface.
 * Handles business logic for managing tasks.
 */
@Service
public class TaskServiceImplementation implements TaskService{
	
	@Autowired
	private TaskRepository tr;
	
	@Autowired
	private UserRepository ur;

	/**
     * Retrieves tasks based on priority and status.
     *
     * @param priority the priority of tasks to filter
     * @param status   the status of tasks to filter
     * @return a list of tasks matching the priority and status
     * @throws GetFailsException if no tasks are found
     */
	
	private static final Logger logger = LoggerFactory.getLogger(TaskServiceImplementation.class);		

	@Override
	public List<Task> getTasksByPriorityAndStatus(String priority, String status) {
		
		logger.info("Fetching tasks with priority: {} and status: {}", priority, status);
		List<Task> lt = tr.findByPriorityAndStatus(priority, status);
	
		if (lt.isEmpty()) {
			logger.error("No tasks found with priority: {} and status: {}", priority, status);
			throw new TasksByPriorityAndStatusListEmptyException("GETALLFAILS" , "Task list is empty");
		}
		else {
			logger.info("Found {} tasks with priority: {} and status: {}", lt.size(), priority, status);
			return lt;
		}
	}

	/**
     * Retrieves tasks that are due within the next 7 days.
     *
     * @return a list of tasks due soon
     * @throws GetFailsException if no tasks are found
     */
	public List<Task> getDueSoonTasks() {
	    logger.info("Fetching tasks due soon (next 7 days)");

	    LocalDate today = LocalDate.now();
	    LocalDate sevenDaysFromNow = today.plusDays(7);
	    
	    List<Task> allTasks = tr.findAll();

	    List<Task> dueSoonTasks = new ArrayList<>();
	    
	    for (Task task : allTasks) {
	        if (task.getDueDate() != null && !task.getDueDate().isBefore(today) && !task.getDueDate().isAfter(sevenDaysFromNow)) {
	            dueSoonTasks.add(task);
	        }
	    }
	    if (dueSoonTasks.isEmpty()) {
	        logger.error("No tasks due soon");
	        throw new TasksDueSoonListEmptyException("GETALLFAILS", "Task list is empty");
	    } else {
	        logger.info("Found {} tasks due soon", dueSoonTasks.size());
	        return dueSoonTasks;
	    }
	}

	/**
     * Retrieves tasks assigned to a specific user and filtered by status.
     *
     * @param userID the ID of the user whose tasks are to be retrieved
     * @param status the status of tasks to filter
     * @return a list of tasks assigned to the user with the specified status
     * @throws GetFailsException if no tasks are found
     */
	@Override
	public List<Task> getTasksByUserIDAndStatus(int UserID, String status) {
		logger.info("Fetching tasks for UserID: {} with status: {}", UserID, status);
		
		Optional<User> u = ur.findById(UserID);
		
		List<Task> tus = new ArrayList<>();
		
		if (u.isPresent()) {
			User u1 = u.get();
			
			for(Task t:u1.getTasks())	{
				if(t.getStatus().equalsIgnoreCase(status)) {
					tus.add(t);
				}
				}
			}
		
		if (tus.isEmpty()) {
			logger.error("No tasks found for UserID: {} with status: {}", UserID, status);
			throw new TasksByUserIDAndStatusEmptyListException("GETALLFAILS","Task list is empty");
		}
		else {
			logger.info("Found {} tasks for UserID: {} with status: {}", tus.size(), UserID, status);
			return tus;
		}
	}

}
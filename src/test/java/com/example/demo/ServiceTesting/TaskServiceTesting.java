package com.example.demo.ServiceTesting;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.Exception.TasksByPriorityAndStatusListEmptyException;
import com.example.demo.Exception.TasksByUserIDAndStatusEmptyListException;
import com.example.demo.Exception.TasksDueSoonListEmptyException;
import com.example.demo.Model.Task;
import com.example.demo.Repository.TaskRepository;
import com.example.demo.Service.TaskService;

import jakarta.transaction.Transactional;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TaskServiceTesting {
	
	@Autowired
	private TaskService ts;
	
	@Test
	@DisplayName("Test for Getting Task using UserId and Status - Positive")
	@Transactional
	public void testGetTaskbyUserIdAndStatus() {
		
		int userid = 2;
		String status = "Pending";
		List<Task> lt = ts.getTasksByUserIDAndStatus(userid, status);
		
		assertFalse(lt.isEmpty());
	} 
	
	@Test
	@DisplayName("Test for getting tasks by UserID and Status - Negative")
	public void testGetTasksByUserIDAndStatus_Negative() {
		int userId = 999;
		String status = "Invalid Status";
		
		assertThrows(TasksByUserIDAndStatusEmptyListException.class, () -> ts.getTasksByUserIDAndStatus(userId, status));
	}
	
	@Test
	@DisplayName("Test for getting tasks using Priority and Status - Positive")
	public void testforGetTaskByPriorityAndStatus() {
		String priority = "Low";
		String status = "Completed";
		
		List<Task> lt = ts.getTasksByPriorityAndStatus(priority, status);
		
		assertFalse(lt.isEmpty());
	}
	
	 @Test
	 @DisplayName("Test for getting tasks by Priority and Status - Negative Case")
	 public void testGetTasksByPriorityAndStatus_Negative() {
	     String priority = "Invalid Priority";
	     String status = "Invalid Status";

	     assertThrows(TasksByPriorityAndStatusListEmptyException.class, () -> ts.getTasksByPriorityAndStatus(priority, status));
     }
	
	
	@Test
	@DisplayName("Test for getting tasks that are due - Positive")
	public void testforgettaskdue() {
		
		List<Task> lt = ts.getDueSoonTasks();
		
		assertFalse(lt.isEmpty());
	}
	
	 @Test
	 @DisplayName("Test for getting tasks due soon - Negative Case")
	 public void testGetDueSoonTasks_Negative() {
		 assertThrows(TasksDueSoonListEmptyException.class, () -> ts.getDueSoonTasks());
	 }
	
	
	

}

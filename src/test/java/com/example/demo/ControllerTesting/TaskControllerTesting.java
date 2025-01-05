package com.example.demo.ControllerTesting;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.demo.Model.Task;
import com.example.demo.Service.TaskService;
import com.example.demo.Controller.TaskController;
import com.example.demo.Exception.TasksByPriorityAndStatusListEmptyException;
import com.example.demo.Exception.TasksByUserIDAndStatusEmptyListException;
import com.example.demo.Exception.TasksDueSoonListEmptyException;
import com.example.demo.GlobalExceptionHandler.TaskGlobalExceptionHandler;

public class TaskControllerTesting {

    @Mock
    private TaskService taskService;

    @InjectMocks
    private TaskController taskController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(taskController).setControllerAdvice(new TaskGlobalExceptionHandler()).build();
    }

    @Test
    void testGetTasksByPriorityAndStatus_Success() throws Exception {
        List<Task> tasks = Arrays.asList(
            new Task("Task 1", "Description 1", LocalDate.now().plusDays(3), "High", "Pending", null, null, null, null, null),
            new Task("Task 2", "Description 2", LocalDate.now().plusDays(5), "High", "Pending", null, null, null, null, null)
        );

        when(taskService.getTasksByPriorityAndStatus("High", "Pending")).thenReturn(tasks);

        mockMvc.perform(get("/api/tasks/priority/High/status/Pending")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].taskName").value("Task 1"))
                .andExpect(jsonPath("$[1].taskName").value("Task 2"));

        verify(taskService, times(1)).getTasksByPriorityAndStatus("High", "Pending");
    }

    @Test
    void testGetDueSoonTasks_Success() throws Exception {
        List<Task> tasks = Arrays.asList(
            new Task("Task 1", "Description 1", LocalDate.now().plusDays(3), "Medium", "Pending", null, null, null, null, null)
        );

        when(taskService.getDueSoonTasks()).thenReturn(tasks);

        mockMvc.perform(get("/api/tasks/due-soon")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].taskName").value("Task 1"));

        verify(taskService, times(1)).getDueSoonTasks();
    }

    @Test
    void testGetTasksByUserIDAndStatus_Success() throws Exception {
        List<Task> tasks = Arrays.asList(
            new Task("Task 1", "Description 1", LocalDate.now(), "Low", "Completed", null, null, null, null, null)
        );

        when(taskService.getTasksByUserIDAndStatus(1, "Completed")).thenReturn(tasks);

        mockMvc.perform(get("/api/tasks/user/1/status/Completed")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].taskName").value("Task 1"));

        verify(taskService, times(1)).getTasksByUserIDAndStatus(1, "Completed");
    }
    
    @Test
    void testGetTasksByPriorityAndStatus_EmptyList() throws Exception {
        when(taskService.getTasksByPriorityAndStatus("High", "Completed"))
                .thenThrow(new TasksByPriorityAndStatusListEmptyException("GETALLFAILS", "Task list is empty"));

        mockMvc.perform(get("/api/tasks/priority/High/status/Completed")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.code").value("GETALLFAILS"))
                .andExpect(jsonPath("$.message").value("Task list is empty"));

        verify(taskService, times(1)).getTasksByPriorityAndStatus("High", "Completed");
    }

    @Test
    void testGetDueSoonTasks_EmptyList() throws Exception {
        when(taskService.getDueSoonTasks())
                .thenThrow(new TasksDueSoonListEmptyException("DUESOONFAILS", "No tasks are due soon"));

        mockMvc.perform(get("/api/tasks/due-soon")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.code").value("DUESOONFAILS"))
                .andExpect(jsonPath("$.message").value("No tasks are due soon"));

        verify(taskService, times(1)).getDueSoonTasks();
    }

    @Test
    void testGetTasksByUserIDAndStatus_EmptyList() throws Exception {
        when(taskService.getTasksByUserIDAndStatus(1, "Pending"))
                .thenThrow(new TasksByUserIDAndStatusEmptyListException("USERIDSTATUSFAILS", "No tasks found for user"));

        mockMvc.perform(get("/api/tasks/user/1/status/Pending")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.code").value("USERIDSTATUSFAILS"))
                .andExpect(jsonPath("$.message").value("No tasks found for user"));

        verify(taskService, times(1)).getTasksByUserIDAndStatus(1, "Pending");
    }

}
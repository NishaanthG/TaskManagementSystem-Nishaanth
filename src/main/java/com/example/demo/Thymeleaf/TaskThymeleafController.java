package com.example.demo.Thymeleaf;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Model.Task;
import com.example.demo.Service.TaskService;

@Controller
public class TaskThymeleafController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/tasks/priority-status")
    public String getTasksByPriorityAndStatus(
            @RequestParam(required = false) String priority,
            @RequestParam(required = false) String status,
            Model model) {

        if (priority != null && status != null) {
            List<Task> tasks = taskService.getTasksByPriorityAndStatus(priority, status);
            model.addAttribute("tasks", tasks);
        }
        return "tasks-by-priority-status";
    }

    @GetMapping("/tasks/due-soon")
    public String getTasksDueSoon(Model model) {
        List<Task> tasks = taskService.getDueSoonTasks();
        model.addAttribute("tasks", tasks);
        return "tasks-due-soon";
    }

    @GetMapping("/tasks/user-status")
    public String getTasksByUserIDAndStatus(
            @RequestParam(required = false) Integer userId,
            @RequestParam(required = false) String status,
            Model model) {

        if (userId != null && status != null) {
            List<Task> tasks = taskService.getTasksByUserIDAndStatus(userId, status);
            model.addAttribute("tasks", tasks);
        }
        return "tasks-by-user-status";
    }
}

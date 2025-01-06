package com.example.demo.Thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Thymeleaf Controller for the dashboard.
 */
@Controller
public class DashBoardThymeleafController {
    
    /**
     * Displays the dashboard.
     *
     * @return the HTML template for the dashboard
     */
    @GetMapping("/dashboard")
    public String showDashboard() {
        return "dashboard";
    }
}
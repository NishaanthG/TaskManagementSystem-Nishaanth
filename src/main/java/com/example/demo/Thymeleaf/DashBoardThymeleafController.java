package com.example.demo.Thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashBoardThymeleafController {
	
	 @GetMapping("/dashboard")
	    public String showDashboard() {
	        return "dashboard";
	    }

}

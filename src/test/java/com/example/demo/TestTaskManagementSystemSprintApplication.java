package com.example.demo;

import org.springframework.boot.SpringApplication;

public class TestTaskManagementSystemSprintApplication {

	public static void main(String[] args) {
		SpringApplication.from(TaskManagementSystemSprintApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}

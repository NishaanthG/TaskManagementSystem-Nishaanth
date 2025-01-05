package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.ServiceImplementation.NotificationServiceImplementation;
import com.example.demo.Success.SuccessResponse;
import com.example.demo.dto.NotificationDto;

@RestController
public class NotificationController {
	
	@Autowired
	private NotificationServiceImplementation ncs;
	
	@PostMapping("api/notifications/post")
	public  ResponseEntity<SuccessResponse> addNotification(@RequestBody NotificationDto a) {
		
		ncs.addNotification(a);
		
		return ResponseEntity.ok(new SuccessResponse("POSTSUCCESS","Notification added successfully"));
		
		
		
	}

}

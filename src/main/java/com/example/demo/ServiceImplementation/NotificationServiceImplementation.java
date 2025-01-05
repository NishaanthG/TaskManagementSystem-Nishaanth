package com.example.demo.ServiceImplementation;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Exception.PostNewCommentFailsException;
import com.example.demo.Model.Notification;
import com.example.demo.Model.User;
import com.example.demo.Repository.NotificationRepository;
import com.example.demo.Repository.UserRepository;
import com.example.demo.dto.NotificationDto;

@Service
public class NotificationServiceImplementation {
	
	@Autowired
	private NotificationRepository nr;
	
	@Autowired
	private UserRepository ur;
	
	public void addNotification(NotificationDto nd) {
		
		Optional<User> u = ur.findById(nd.getUserID());
		
		if(u.isEmpty()) {
			throw new PostNewCommentFailsException("ADDFAILS", "User doesn't exist");
		}
		
		else {
			User u1 = u.get();
			
			Notification n = new Notification();
			n.setCreatedAt(LocalDateTime.now());
			n.setText(nd.getText());
			n.setUser(u1);
			
			nr.save(n);
		}
		
	}
	

}

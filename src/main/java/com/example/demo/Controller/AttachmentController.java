package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.ServiceImplementation.AttachmentServiceImplementation;
import com.example.demo.Success.SuccessResponse;
import com.example.demo.dto.AttachmentDto;

@RestController
public class AttachmentController {
	
	@Autowired
	private AttachmentServiceImplementation asi;
	
	@PostMapping("/attachments/add")
	public ResponseEntity<SuccessResponse> addAttachment(@RequestBody AttachmentDto a){
		
		asi.addAttachment(a);
		
		return ResponseEntity.ok(new SuccessResponse("POSTSUCCESS","Attachment added successfully"));
		
	}

}

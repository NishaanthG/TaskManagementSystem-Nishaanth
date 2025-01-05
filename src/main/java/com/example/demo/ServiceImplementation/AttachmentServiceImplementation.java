package com.example.demo.ServiceImplementation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

import com.example.demo.Exception.PostNewCommentFailsException;
import com.example.demo.Model.Attachment;
import com.example.demo.Model.Task;
import com.example.demo.Repository.AttachmentRepository;
import com.example.demo.Repository.TaskRepository;
import com.example.demo.dto.AttachmentDto;

@Service
public class AttachmentServiceImplementation {
	
	@Autowired
	private AttachmentRepository ar;
	
	@Autowired
	private TaskRepository tr;
	
	public void addAttachment(AttachmentDto a) {
		
		Optional<Task> ot = tr.findById(a.getTaskID());
		
		if(ot.isPresent()) {
			Task t = ot.get();
			
			Attachment a1 = new Attachment();
			a1.setFileName(a.getFileName());
			a1.setFilePath(a.getFilePath());
			a1.setTask(t);
			
			ar.save(a1);
		}
		else {
			throw new PostNewCommentFailsException("ADDFAILS", "Task Id not found");
		}
	} 

}

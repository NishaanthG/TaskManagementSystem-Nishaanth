package com.example.demo.ServiceTesting;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.Exception.DeleteCommentFailsException;
import com.example.demo.Exception.PostNewCommentFailsException;
import com.example.demo.Exception.UpdateCommentFailsException;
import com.example.demo.Model.Comment;
import com.example.demo.Model.Task;
import com.example.demo.Model.User;
import com.example.demo.Repository.CommentRepository;
import com.example.demo.Service.CommentService;
import com.example.demo.dto.CommentDTO;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CommentServiceTesting {
	
	@Autowired
	private CommentService cs; 
	
	@Autowired
	private CommentRepository cr;
	
	@Test
	@DisplayName("Test for deleting a Comment - Positive")
	public void TestForDeleteComment_Positive() {
		int length = cr.findAll().size();
		
		cs.DeleteCommentById(3);
		
		assertEquals(length-1, cr.findAll().size());
	}
	
	@Test
	@DisplayName("Test for deleting a Comment - Negative")
	public void testDeleteCommentById_Negative() {
		
		int invalidCommentId = 999;
		
		assertThrows(DeleteCommentFailsException.class, () -> cs.DeleteCommentById(invalidCommentId));
	}
	
	@Test
	@DisplayName("Test for Adding a Comment - Positive")
	public void testAddComment_Positive() {
	    int initialLength = cr.findAll().size();

	    CommentDTO c = new CommentDTO();
	    c.setText("This is a new Comment");
	    c.setTaskID(1);
	    c.setUserID(1);

	    cs.addComment(c);

	    assertEquals(initialLength + 1, cr.findAll().size());
	}

	@Test
	@DisplayName("Test for Adding a Comment - Negative")
	public void testAddComment_Negative() {
	    CommentDTO c = new CommentDTO();
	    c.setText("Invalid Comment");
	    c.setTaskID(999);
	    c.setUserID(999);

	    assertThrows(PostNewCommentFailsException.class, () -> cs.addComment(c));
	}
	
	@Test
	@DisplayName("Test for update a comment - Positive")
	public void testUpdateComment_Positive() {
		Optional<Comment> oc = cr.findById(2);
		Comment existingComment = oc.get();
		
		existingComment.setText("Updated Comment Text");
		cs.UpdateComment(2, existingComment);
		
		Comment updatedComment = cr.findById(2).get();
		
		assertEquals("Updated Comment Text", updatedComment.getText());
	}
	
	@Test
	@DisplayName("Test for update a comment - Negative")
	public void testUpdateComment_Negative() {
		Comment invalidComment = new Comment();
		invalidComment.setText("Invalid Update");
		
		assertThrows(UpdateCommentFailsException.class, () -> cs.UpdateComment(999, invalidComment));
	}

}

package com.example.demo.ServiceImplementation;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Exception.DeleteCommentFailsException;
import com.example.demo.Exception.PostNewCommentFailsException;
import com.example.demo.Exception.UpdateCommentFailsException;
import com.example.demo.Model.Comment;
import com.example.demo.Model.Task;
import com.example.demo.Model.User;
import com.example.demo.Repository.CommentRepository;
import com.example.demo.Repository.TaskRepository;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.CommentService;
import com.example.demo.dto.CommentDTO;

/**
 * Implementation of the {@link CommentService} interface.
 * Handles business logic for managing comments.
 */
@Service
public class CommentServiceImplementation implements CommentService{
	
	@Autowired
	private CommentRepository cr;
	
	@Autowired
	private TaskRepository tr;
	
	@Autowired
	private UserRepository ur;
	
	private static final Logger logger = LoggerFactory.getLogger(CommentServiceImplementation.class);

	/**
     * Adds a new comment.
     *
     * @param c the {@link CommentDTO} object containing the comment details
     * @throws PostFailsException if the associated task or user does not exist
     */
	@Override
	public void addComment(CommentDTO c) {
	    logger.info("Adding new comment: {}", c.getText());
	    logger.info("Fetching Task ID: {}", c.getTaskID());
	    logger.info("Fetching User ID: {}", c.getUserID());
	    
	    Optional<Task> taskOpt = tr.findById(c.getTaskID());
	    Optional<User> userOpt = ur.findById(c.getUserID());
	    
	    if (taskOpt.isEmpty()) {
	        logger.error("Task with ID {} does not exist", c.getTaskID());
	        throw new PostNewCommentFailsException("ADDFAILS", "Task does not exist");
	    }
	    if (userOpt.isEmpty()) {
	        logger.error("User with ID {} does not exist", c.getUserID());
	        throw new PostNewCommentFailsException("ADDFAILS", "User does not exist");
	    }
	    
	    Task task = taskOpt.get();
	    User user = userOpt.get();
	    
	    Comment c1 = new Comment(); 
	    c1.setCreatedAt(LocalDateTime.now());
	    c1.setText(c.getText());
	    c1.setTask(task);
	    c1.setUser(user);
	    
	    cr.save(c1);
	    logger.info("Comment added successfully: {}", c.getText());
	}

	/**
     * Updates an existing comment by its ID.
     *
     * @param commentid the ID of the comment to update
     * @param c1        the updated {@link Comment} object
     * @throws UpdateFailsException if the comment does not exist
     */
	@Override
	public void UpdateComment(int commentid , Comment c1) {
		
		logger.info("Updating comment with ID: {}", commentid);
		Optional<Comment> oc = cr.findById(commentid);
		
		if(oc.isEmpty()) {
			logger.error("Comment with ID {} does not exist", commentid);
			throw new UpdateCommentFailsException("UPDTFAILS" , "Category doesn't exist");
			}
		else {
               Comment c = oc.get();
			
			   if(c1.getText()!=null) {
				c.setText(c1.getText());
				c.setCreatedAt(LocalDateTime.now());
				cr.save(c);
				logger.info("Comment with ID {} updated successfully", commentid);
		   }
		}
	}
	
	 /**
     * Deletes a comment by its ID.
     *
     * @param commentid the ID of the comment to delete
     * @throws DeleteFailsException if the comment does not exist
     */
	@Override
	public void DeleteCommentById(int commentid) {
		
		logger.info("Deleting comment with ID: {}", commentid);
		Optional<Comment> oc = cr.findById(commentid);
		
		if(oc.isEmpty()) {
			logger.error("Comment with ID {} does not exist", commentid);
			throw new DeleteCommentFailsException("DLTFAILS","Comments doesn't exist");
		}
		else {
			Comment c = oc.get();
			cr.delete(c);
			logger.info("Comment with ID {} deleted successfully", commentid);
		}
		
	}

	@Override
	public List<Comment> getAllComments() {
	    logger.info("Fetching all comments from the database");
	    return cr.findAll();
	}
	
	@Override
	public Comment getCommentById(int commentid) {
	    logger.info("Fetching comment with ID: {}", commentid);
	    Optional<Comment> commentOpt = cr.findById(commentid);
	    
	    return commentOpt.get();
	}
}

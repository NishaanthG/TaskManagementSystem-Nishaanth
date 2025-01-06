package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Comment;
import com.example.demo.Service.CommentService;
import com.example.demo.Success.SuccessResponse;
import com.example.demo.dto.CommentDTO;

import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Rest Controller for managing comments.
 * Provides endpoints for creating, updating, and deleting comments.
 */
@RestController
public class CommentController {

    private static final Logger logger = LoggerFactory.getLogger(CommentController.class);

    @Autowired
    private CommentService cs;

    /**
     * Deletes a comment by its ID.
     * 
     * @param commentId the ID of the comment to delete
     * @return ResponseEntity with success message
     */
    @DeleteMapping("/api/comments/delete/{commentId}")
    public ResponseEntity<SuccessResponse> DeleteCommentById(@PathVariable int commentId) {
        logger.info("Request received to delete comment with ID: {}", commentId);
        cs.DeleteCommentById(commentId);
        logger.info("Comment with ID: {} deleted successfully", commentId);
        return ResponseEntity.ok(new SuccessResponse("DELETESUCCESS", "Comment deleted successfully"));
    }

    /**
     * Adds a new comment.
     * 
     * @param c the CommentDTO object containing comment details
     * @return ResponseEntity with success message
     */
    @RequestMapping(value = "/api/comments/post", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<SuccessResponse> AddNewComment(@Valid @RequestBody CommentDTO c) {
        logger.info("Request received to add a new comment: {}", c);
        cs.addComment(c);
        logger.info("Comment added successfully: {}", c);
        return ResponseEntity.ok(new SuccessResponse("POSTSUCCESS", "Comments added successfully"));
    }

    /**
     * Updates a comment by its ID.
     * 
     * @param commentId the ID of the comment to update
     * @param c the Comment object containing updated details
     * @return ResponseEntity with success message
     */
    @PutMapping("/api/comments/update/{commentId}")
    public ResponseEntity<SuccessResponse> UpdateComment(@PathVariable int commentId, @Valid @RequestBody Comment c) {
        logger.info("Request received to update comment with ID: {}", commentId);
        cs.UpdateComment(commentId, c);
        logger.info("Comment with ID: {} updated successfully", commentId);
        return ResponseEntity.ok(new SuccessResponse("UPDATESUCCESS", "Comment Updated Successfully"));
    }
}

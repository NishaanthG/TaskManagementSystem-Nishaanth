package com.example.demo.Service;

import java.util.List;

import com.example.demo.Model.Comment;
import com.example.demo.dto.CommentDTO;

/**
 * Service interface for managing Comment entities.
 * Provides methods to perform operations such as adding, updating, deleting, and retrieving comments.
 */
public interface CommentService {

    /**
     * Adds a new comment.
     * 
     * @param c the CommentDTO object containing the details of the comment to be added.
     */
    public void addComment(CommentDTO c);

    /**
     * Deletes a comment by its unique ID.
     * 
     * @param commentid the ID of the comment to delete.
     */
    public void DeleteCommentById(int commentid);

    /**
     * Updates the details of an existing comment.
     * 
     * @param commentid the ID of the comment to update.
     * @param c1 the Comment object containing updated information.
     */
    public void UpdateComment(int commentid, Comment c1);

    /**
     * Retrieves all comments.
     * 
     * @return a list of all Comment objects.
     */
    public List<Comment> getAllComments();

    /**
     * Retrieves a comment by its unique ID.
     * 
     * @param commentid the ID of the comment to retrieve.
     * @return the Comment object corresponding to the provided ID.
     */
    public Comment getCommentById(int commentid);

}

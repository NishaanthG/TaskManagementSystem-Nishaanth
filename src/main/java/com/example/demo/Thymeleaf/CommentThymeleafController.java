package com.example.demo.Thymeleaf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Model.Comment;
import com.example.demo.Service.CommentService;
import com.example.demo.dto.CommentDTO;

/**
 * Thymeleaf Controller for managing comments.
 */
@Controller
@RequestMapping("/comments")
public class CommentThymeleafController {

    @Autowired
    private CommentService cs;

    /**
     * Displays the form for creating a new comment.
     *
     * @param model the model to pass data to the view
     * @return the HTML template for creating a new comment
     */
    @GetMapping("/new")
    public String showCreateCommentForm(Model model) {
        model.addAttribute("comment", new CommentDTO());
        return "comment-form";
    }

    /**
     * Handles the submission of a new comment.
     *
     * @param comment the comment data transfer object
     * @return a redirect to the comments page
     */
    @PostMapping("/add")
    public String addComment(@ModelAttribute("comment") CommentDTO comment) {
        cs.addComment(comment);
        return "redirect:/comments/all";
    }

    /**
     * Displays all comments.
     *
     * @param model the model to pass data to the view
     * @return the HTML template for displaying all comments
     */
    @GetMapping("/all")
    public String listAllComments(Model model) {
        model.addAttribute("comments", cs.getAllComments());
        return "comment-list";
    }

    /**
     * Displays the form for updating a comment.
     *
     * @param commentId the ID of the comment to update
     * @param model     the model to pass data to the view
     * @return the HTML template for updating a comment
     */
    @GetMapping("/edit/{commentId}")
    public String showEditCommentForm(@PathVariable int commentId, Model model) {
        Comment existingComment = cs.getCommentById(commentId); 
        model.addAttribute("comment", existingComment);
        return "comment-edit";
    }

    /**
     * Handles the submission of an updated comment.
     *
     * @param commentId     the ID of the comment to update
     * @param updatedComment the updated comment data
     * @return a redirect to the comments page
     */
    @PostMapping("/update/{commentId}")
    public String updateComment(@PathVariable int commentId, @ModelAttribute("comment") Comment updatedComment) {
        cs.UpdateComment(commentId, updatedComment);
        return "redirect:/comments/all";
    }

    /**
     * Deletes a comment.
     *
     * @param commentId the ID of the comment to delete
     * @return a redirect to the comments page
     */
    @GetMapping("/delete/{commentId}")
    public String deleteComment(@PathVariable int commentId) {
        cs.DeleteCommentById(commentId);
        return "redirect:/comments/all";
    }
}
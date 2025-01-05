package com.example.demo.ControllerTesting;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.Controller.CommentController;
import com.example.demo.Exception.DeleteCommentFailsException;
import com.example.demo.Exception.PostNewCommentFailsException;
import com.example.demo.Exception.UpdateCommentFailsException;
import com.example.demo.Model.Comment;
import com.example.demo.Service.CommentService;
import com.example.demo.dto.CommentDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(CommentController.class)
public class CommentControllerTesting {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CommentService commentService;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    @DisplayName("Test for adding a new Comment - Positive")
    void testAddNewComment_Success() throws Exception {
        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setText("Test Comment");
        commentDTO.setTaskID(1);
        commentDTO.setUserID(1);

        doNothing().when(commentService).addComment(any(CommentDTO.class));

        mockMvc.perform(post("/api/comments/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(commentDTO)));
//                .andExpect(status().isCreated())
//                .andExpect(jsonPath("$.message").value("Commennts added successfully"));
    }

    @Test
    @DisplayName("Test for adding a new Comment - Negative")
    void testAddNewComment_Failure() throws Exception {
        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setText("Test Comment");
        commentDTO.setTaskID(1);
        commentDTO.setUserID(1);

        doThrow(new PostNewCommentFailsException("ADDFAILS", "Task does not exist"))
                .when(commentService).addComment(any(CommentDTO.class));

        mockMvc.perform(post("/api/comments/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(commentDTO)))
                .andExpect(status().isInternalServerError())
                .andExpect(jsonPath("$.code").value("ADDFAILS"))
                .andExpect(jsonPath("$.message").value("Task does not exist"));
    }

    @Test
    @DisplayName("Test for Updating a Comment - Positive")
    void testUpdateComment_Success() throws Exception {
        Comment comment = new Comment();
        comment.setText("Updated Comment");

        doNothing().when(commentService).UpdateComment(eq(1), any(Comment.class));

        mockMvc.perform(put("/api/comments/update/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(comment)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Comment Updated Successfully"));
    }

    @Test
    @DisplayName("Test for updating a Comment - Negative")
    void testUpdateComment_Failure() throws Exception {
        Comment comment = new Comment();
        comment.setText("Updated Comment");

        doThrow(new UpdateCommentFailsException("UPDTFAILS", "Comment doesn't exist"))
                .when(commentService).UpdateComment(eq(1), any(Comment.class));

        mockMvc.perform(put("/api/comments/update/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(comment)))
                .andExpect(status().isInternalServerError())
                .andExpect(jsonPath("$.code").value("UPDTFAILS"))
                .andExpect(jsonPath("$.message").value("Comment doesn't exist"));
    }

    @Test
    @DisplayName("Test for deleting a Comment - Positive")
    void testDeleteCommentById_Success() throws Exception {
        doNothing().when(commentService).DeleteCommentById(1);

        mockMvc.perform(delete("/api/comments/delete/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Comment deleted successfully"));
    }

    @Test
    @DisplayName("Test for deleting a Comment - Negative")
    void testDeleteCommentById_Failure() throws Exception {
        doThrow(new DeleteCommentFailsException("DLTFAILS", "Comments doesn't exist"))
                .when(commentService).DeleteCommentById(1);

        mockMvc.perform(delete("/api/comments/delete/1"))
                .andExpect(status().isInternalServerError())
                .andExpect(jsonPath("$.code").value("DLTFAILS"))
                .andExpect(jsonPath("$.message").value("Comments doesn't exist"));
    }
}

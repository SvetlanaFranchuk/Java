package org.example.hotelbookingapplication.controller;

import jakarta.validation.constraints.Min;
import org.example.hotelbookingapplication.dto.comment.CommentDto;
import org.example.hotelbookingapplication.entity.comment.Comment;
import org.example.hotelbookingapplication.entity.user.User;
import org.example.hotelbookingapplication.repository.CommentRepository;
import org.example.hotelbookingapplication.repository.UserRepository;
import org.example.hotelbookingapplication.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@RestController
@RequestMapping(path="comment")
public class CommentController {

    private CommentRepository commentRepository;
    private UserRepository userRepository;
    private CommentService commentService;

 @Autowired
 public CommentController(CommentRepository commentRepository, UserRepository userRepository,
                          CommentService commentService) {
        this.commentRepository = commentRepository;
        this.userRepository = userRepository;
        this.commentService = commentService;
    }

    @PostMapping("/{id}")
    public void addNewCommit(@RequestBody Comment comment, @PathVariable("id") @Min(0) long id){
     User user = userRepository.getReferenceById(id);
     Comment comment1 = new Comment(null, comment.getMessage(), LocalDate.now(), userRepository.getReferenceById(id));
     commentRepository.saveAndFlush(comment1);
     user.addComment(comment);
    }

    @GetMapping("/allComment")
    public List<CommentDto> getAllComment(){
    return commentService.readAllComment();
    }
}

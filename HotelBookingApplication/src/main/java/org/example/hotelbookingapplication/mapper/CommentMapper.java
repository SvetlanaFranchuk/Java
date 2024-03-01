package org.example.hotelbookingapplication.mapper;

import jakarta.annotation.Nullable;
import org.example.hotelbookingapplication.dto.comment.CommentDto;
import org.example.hotelbookingapplication.entity.comment.Comment;
import org.example.hotelbookingapplication.entity.user.User;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class CommentMapper {
 public Comment toComment(@Nullable Long id, String message, User user){
     Comment comment = new Comment();
     comment.setId(id);
     comment.setMessage(message);
     comment.setDateMessage(LocalDate.now());
     comment.setUser(user);
     return comment;
 }

 public CommentDto toCommentDto(Comment comment){
     return new CommentDto(comment.getId(), comment.getMessage(), comment.getDateMessage(),
             comment.getUser().getFirstName(), comment.getUser().getLastName());
 }
}

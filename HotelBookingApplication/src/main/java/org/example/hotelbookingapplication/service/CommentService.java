package org.example.hotelbookingapplication.service;

import org.example.hotelbookingapplication.dto.comment.CommentDto;
import org.example.hotelbookingapplication.entity.comment.Comment;
import org.example.hotelbookingapplication.mapper.CommentMapper;
import org.example.hotelbookingapplication.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService {
    private CommentRepository repository;
    private CommentMapper commentMapper;
    @Autowired
    public CommentService(CommentRepository repository, CommentMapper commentMapper) {
        this.repository = repository;
        this.commentMapper = commentMapper;
    }

    public List<CommentDto> readAllComment(){
        List<Comment> comments = repository.findAll() ;
        return comments.stream().map(c-> commentMapper.toCommentDto(c))
                .collect(Collectors.toList());
    }
}

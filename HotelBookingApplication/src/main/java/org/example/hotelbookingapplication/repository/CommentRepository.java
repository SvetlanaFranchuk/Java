package org.example.hotelbookingapplication.repository;

import org.example.hotelbookingapplication.entity.comment.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
//    @Query("SELECT c.dateMessage, c.message, c.user.firstName, c.user.lastName FROM Comment c")
//    List<Comment> findAll();
}

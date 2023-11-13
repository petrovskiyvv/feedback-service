package com.example.feedbackservice.repositories;

import com.example.feedbackservice.models.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment, Long> {
}

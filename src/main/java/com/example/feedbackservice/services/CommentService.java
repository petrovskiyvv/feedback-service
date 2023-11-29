package com.example.feedbackservice.services;

import com.example.feedbackservice.models.Comment;
import com.example.feedbackservice.models.ReviewedObject;
import com.example.feedbackservice.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService {
    private final CommentRepository repository;

    @Autowired
    public CommentService(CommentRepository repository) {
        this.repository = repository;
    }
    public void saveComment(String description, String name_object){
        Comment comment = new Comment();
        comment.setDescription(description);
        comment.setName_object(name_object);
        repository.save(comment);
    }
    public Comment getById(Long id){
        return repository.findById(id).get();
    }
    public List<Comment> getAllComments(){
        List<Comment> result = new ArrayList<>();
        repository.findAll().forEach(result::add);
        return result;
    }
}

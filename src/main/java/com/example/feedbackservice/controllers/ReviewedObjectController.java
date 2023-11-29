package com.example.feedbackservice.controllers;

import com.example.feedbackservice.models.Comment;
import com.example.feedbackservice.models.ReviewedObject;
import com.example.feedbackservice.services.CommentService;
import com.example.feedbackservice.services.ReviewedObjectCommentService;
import com.example.feedbackservice.services.ReviewedObjectService;
//import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ReviewedObjectController {
    @Value("${establishment}")
    private String establishment;
    private final List<ReviewedObjectService> reviewedObjectServices;
    private final CommentService commentService;
    private final ReviewedObjectCommentService reviewedObjectCommentService;
    private final Map<String, ReviewedObjectService> reviewedObjectServiceMap = new HashMap<>();

    @Autowired
    public ReviewedObjectController(List<ReviewedObjectService> reviewedObjectServices, CommentService commentService, ReviewedObjectCommentService reviewedObjectCommentService) {
        this.reviewedObjectServices = reviewedObjectServices;
        this.commentService = commentService;
        this.reviewedObjectCommentService = reviewedObjectCommentService;
        reviewedObjectServices.forEach(reviewedObjectService -> {
            reviewedObjectServiceMap.put(reviewedObjectService.getEstablishment(), reviewedObjectService);
        });

    }

    @GetMapping("/allReviewedObject")
    @ResponseBody
    public List<ReviewedObject> getReviewedObjects() {
        return getService().getAllReviewedObject();
    }

    @GetMapping("/addReviewedObject/{name}/{description}/{coordinates}/{establishment}")
    @ResponseBody
    public List<ReviewedObject> addReviewedObject(
            @PathVariable String name,
            @PathVariable String description,
            @PathVariable String coordinates,
            @PathVariable String establishment) {
        ReviewedObject newReviewedObject = new ReviewedObject(name, description, coordinates);
        newReviewedObject.setEstablishment(establishment);
        getService().saveReviewedObject(newReviewedObject);
        return getReviewedObjects();
    }
    @GetMapping("/addComment/{name_object}/{description}")
    @ResponseBody
    public List<Comment> addReviewedObject(
            @PathVariable String description,
            @PathVariable String name_object) {
        Comment newComment = new Comment(name_object, description);
        commentService.saveComment( description, name_object);
        return getAllComments();
    }

    @GetMapping("/allComments")
    @ResponseBody
    private List<Comment> getAllComments() {
        return commentService.getAllComments();
    }

    private ReviewedObjectService getService() {
        return reviewedObjectServiceMap.get(establishment);
    }


}
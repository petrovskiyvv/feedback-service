package com.example.feedbackservice.services;

import com.example.feedbackservice.models.Comment;
import com.example.feedbackservice.models.ReviewedObject;
import com.example.feedbackservice.models.ReviewedObjectCommentLink;
import com.example.feedbackservice.repositories.ReviewedObjectCommentLinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewedObjectCommentService {
    private final ReviewedObjectCommentLinkRepository reviewedObjectCommentLinkRepository;
    private final ReviewedObjectService reviewedObjectService;

    @Autowired
    public ReviewedObjectCommentService(ReviewedObjectCommentLinkRepository reviewedObjectCommentLinkRepository, ReviewedObjectService reviewedObjectService) {
        this.reviewedObjectCommentLinkRepository = reviewedObjectCommentLinkRepository;
        this.reviewedObjectService = reviewedObjectService;
    }

    public ReviewedObjectCommentLink addCommentToReviewedObject(ReviewedObject reviewedObject, Comment comment) {
        ReviewedObjectCommentLink reviewedObjectCommentLink = new ReviewedObjectCommentLink(reviewedObject, comment);
        reviewedObjectCommentLinkRepository.save(reviewedObjectCommentLink);
        return reviewedObjectCommentLink;
    }

    public List<ReviewedObject> getCommentsByReviewedObjectName(String reviewedObjectName) {
        ReviewedObject reviewedObject = new ReviewedObject(reviewedObjectName);
        List<ReviewedObjectCommentLink> reviewedObjectCommentLinks = reviewedObjectCommentLinkRepository.findByReviewedObject(reviewedObject);
        return reviewedObjectCommentLinks.stream().map(reviewedObjectCommentLink -> reviewedObjectCommentLink.getReviewedObject()).collect(Collectors.toList());
    }

    public List<ReviewedObject> getCommentsByReviewedObjectId(Long reviewedObjectId) {
        ReviewedObject reviewedObject = reviewedObjectService.getReviewedObjectById(reviewedObjectId);
        List<ReviewedObjectCommentLink> reviewedObjectCommentLinks = reviewedObjectCommentLinkRepository.findByReviewedObject(reviewedObject);
        return reviewedObjectCommentLinks.stream().map(reviewedObjectCommentLink -> reviewedObjectCommentLink.getReviewedObject()).collect(Collectors.toList());
    }
//    public List<ReviewedObject> getReviewedObjectsByUserIdAndEstablishment(Long userId, String establishment){
//        User user = userService.getById(userId);
//        List<ReviewedObjectCommentLink> reviewedObjectCommentLinks = reviewedObjectCommentLinkRepository.findByUserId(userId);
//        return reviewedObjectCommentLinks.stream().map(reviewedObjectCommentLinks -> reviewedObjectCommentLinks.getReviewedObject()).filter(reviewedObject -> reviewedObject.getEstablishment());
//    }
//
//    public List<ReviewedObject> getCinemaReviewedObjectsByUserId(Long userId){
//        return getReviewedObjectsByUserIdAndEstablishment(userId, "Cinema");
//    }
//    public List<ReviewedObject> getTheatreReviewedObjectsByUserId(Long userId){
//        return getReviewedObjectsByUserIdAndEstablishment(userId, "Theatre");
//    }
}


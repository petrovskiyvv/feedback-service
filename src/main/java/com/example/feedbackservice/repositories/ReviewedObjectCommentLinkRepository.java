package com.example.feedbackservice.repositories;

import com.example.feedbackservice.models.ReviewedObject;
import com.example.feedbackservice.models.ReviewedObjectCommentLink;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReviewedObjectCommentLinkRepository extends CrudRepository<ReviewedObjectCommentLink, Long>{
    List<ReviewedObjectCommentLink> findByReviewedObject(ReviewedObject reviewedObject);
//    List<ReviewedObjectCommentLink> findByUser(User user);
}
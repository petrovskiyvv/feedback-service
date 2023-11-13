package com.example.feedbackservice.services;

import com.example.feedbackservice.models.ReviewedObject;

import java.util.List;

public interface ReviewedObjectService {
    List<ReviewedObject> getAllReviewedObject();

    void saveReviewedObject(String name, String description);
    String getEstablishment();
    ReviewedObject getReviewedObjectById(Long id);

    void saveReviewedObject(ReviewedObject reviewedObject);
}

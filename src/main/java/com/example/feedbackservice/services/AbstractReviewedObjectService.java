package com.example.feedbackservice.services;

import com.example.feedbackservice.models.ReviewedObject;
import com.example.feedbackservice.repositories.ReviewedObjectCommentLinkRepository;
import com.example.feedbackservice.repositories.ReviewedObjectRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AbstractReviewedObjectService implements ReviewedObjectService {
    protected final ReviewedObjectRepository repository;
    public AbstractReviewedObjectService(ReviewedObjectRepository repository){
        this.repository = repository;
    }
    @Override
    public List<ReviewedObject> getAllReviewedObject() {
        List<ReviewedObject> result = new ArrayList<>();
        repository.findAll().forEach(result::add);
        return result.stream().filter(reviewedObject -> reviewedObject.getEstablishment().equals(getEstablishment())).collect(Collectors.toList());
    }

    @Override
    public void saveReviewedObject(String name, String description) {
        ReviewedObject newReviewedObject = new ReviewedObject(name, description);
        repository.save(newReviewedObject);
    }

    @Override
    public String getEstablishment() {
        return null;
    }

    @Override
    public ReviewedObject getReviewedObjectById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public void saveReviewedObject(ReviewedObject reviewedObject) {
        repository.save(reviewedObject);
    }
}

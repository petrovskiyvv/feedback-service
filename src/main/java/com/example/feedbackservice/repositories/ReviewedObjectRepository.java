package com.example.feedbackservice.repositories;

import com.example.feedbackservice.models.ReviewedObject;
import org.springframework.data.repository.CrudRepository;

public interface ReviewedObjectRepository extends CrudRepository<ReviewedObject, Long> {
}

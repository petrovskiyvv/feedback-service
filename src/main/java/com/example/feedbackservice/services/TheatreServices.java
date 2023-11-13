package com.example.feedbackservice.services;

import com.example.feedbackservice.models.ReviewedObject;
import com.example.feedbackservice.repositories.ReviewedObjectCommentLinkRepository;
import com.example.feedbackservice.repositories.ReviewedObjectRepository;
import org.springframework.stereotype.Service;

@Service
public class TheatreServices extends AbstractReviewedObjectService {
    public TheatreServices(ReviewedObjectRepository repository){
        super(repository);
    }

    @Override
    public String getEstablishment() {
        return "Theatre";
    }
}

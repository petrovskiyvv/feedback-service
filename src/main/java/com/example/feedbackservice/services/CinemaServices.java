package com.example.feedbackservice.services;

import com.example.feedbackservice.models.ReviewedObject;
import com.example.feedbackservice.repositories.ReviewedObjectCommentLinkRepository;
import com.example.feedbackservice.repositories.ReviewedObjectRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class CinemaServices extends AbstractReviewedObjectService {
    public CinemaServices(ReviewedObjectRepository repository){
        super(repository);
    }

    @Override
    public String getEstablishment() {
        return "Cinema";
    }
}

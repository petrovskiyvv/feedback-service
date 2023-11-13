package com.example.feedbackservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;


@Entity
public class Comment{
    @Id
    @GeneratedValue
    private Long id;
    private String description;
//    private String image;
    public Comment(){

    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    public String getImage() {
//        return image;
//    }

//    public void setImage(String image) {
//        this.image = image;
//    }
}

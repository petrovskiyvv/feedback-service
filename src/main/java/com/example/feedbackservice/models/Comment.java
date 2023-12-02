package com.example.feedbackservice.models;

import jakarta.persistence.*;


@Entity
public class Comment {
    @Id
    @GeneratedValue
    private Long id;
    private String name_object;
    private String description;
    public Comment(String name_object, String description) {
        this.name_object = name_object;
        this.description = description;
    }

    public Comment() {

    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }
    public String getName_object() {
        return name_object;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public void setName_object(String name_object) {
        this.name_object = name_object;
    }
}

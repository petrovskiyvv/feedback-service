package com.example.feedbackservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class ReviewedObject {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    private String coordinates;
    private String establishment;

    public ReviewedObject(String name) {
        this.name = name;
    }

    public ReviewedObject(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public ReviewedObject(String name, String description, String coordinates) {
        this.name = name;
        this.description = description;
        this.coordinates
                = coordinates;
    }

    public ReviewedObject() {

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return this.name = name;
    }

    public String getDescription() {
        return this.description = description;
    }

    public String getCoordinates() {
        return this.coordinates = coordinates;
    }

    public String getEstablishment() {
        return establishment;
    }

    public void setName() {
        this.name = name;
    }

    public void setDescription() {
        this.description = description;
    }

    public void setCoordinates() {
        this.coordinates = coordinates;
    }

    public void setEstablishment(String establishment) {
        this.establishment = establishment;
    }
}

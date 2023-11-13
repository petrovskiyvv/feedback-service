package com.example.feedbackservice.models;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.Objects;

@Entity
public class ReviewedObjectCommentLink {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private ReviewedObject reviewedObject;
    @OneToOne
    private Comment comment;
    //    @ManyToOne
    //    private User user;
    @CreationTimestamp
    private Date creationDate;

    public ReviewedObjectCommentLink(ReviewedObject reviewedObject, Comment comment) {
        this.reviewedObject = reviewedObject;
        this.comment = comment;
    }

    public ReviewedObjectCommentLink() {
    }

    public Long getId() {
        return id;
    }

    public ReviewedObject getReviewedObject() {
        return reviewedObject;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public Comment getComment() {
        return comment;
    }

//    public User getUser() {
//        return user;
//    }


    public void setReviewedObject(ReviewedObject reviewedObject) {
        this.reviewedObject = reviewedObject;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

//    public void setUser(User user) {
//        this.user = user;
//    }

    @Override
    public int hashCode() {
        return Objects.hash(reviewedObject.getId(), comment.getId());
    }
}

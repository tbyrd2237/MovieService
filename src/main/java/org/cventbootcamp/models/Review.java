package org.cventbootcamp.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String reviewerName;
    private int rating;
    private String imdbId;
    private String reviewText;

    public Review() {
    }

    public Review(Long id, String reviewerName, int rating, String imdbId, String reviewText) {
        this.id = id;
        this.reviewerName = reviewerName;
        this.rating = rating;
        this.imdbId = imdbId;
        this.reviewText = reviewText;
    }

    public Long getId() {
        return id;
    }

    public String getReviewerName() {
        return reviewerName;
    }

    public int getRating() {
        return rating;
    }

    public String getimdbId() {
        return imdbId;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setReviewerName(String reviewerName) {
        this.reviewerName = reviewerName;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setimdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }
}

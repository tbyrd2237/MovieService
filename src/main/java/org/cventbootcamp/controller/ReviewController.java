package org.cventbootcamp.controller;

import org.cventbootcamp.models.Movie;
import org.cventbootcamp.models.Review;
import org.cventbootcamp.services.MovieService;
import org.cventbootcamp.services.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/review")
public class ReviewController {
    private ReviewService reviewService;

    public ReviewController(ReviewService reviewservice) {
        this.reviewService = reviewService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Review> getReviewById(Long id) {
        Review review = this.reviewService.getReviewById(id);
        return new ResponseEntity<>(review, HttpStatus.OK);
    }

}
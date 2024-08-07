package org.cventbootcamp.controller;

import org.cventbootcamp.models.Movie;
import org.cventbootcamp.models.Review;
import org.cventbootcamp.services.MovieService;
import org.cventbootcamp.services.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/review")
public class ReviewController {
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Review> getReviewById(@PathVariable Long id) {
        Optional<Review> reviewOptional = reviewService.getReviewById(id);
        if (reviewOptional.isPresent()) {
            return new ResponseEntity<>(reviewOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    //@GetMapping("/{id}")
    //public ResponseEntity<Review> getReviewById(Long id) {
       // Optional<Review> review = reviewService.getReviewById(id);;
        //return new ResponseEntity<>(review, HttpStatus.OK);
   // }

}
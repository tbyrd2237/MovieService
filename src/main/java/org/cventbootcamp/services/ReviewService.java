package org.cventbootcamp.services;

import org.cventbootcamp.models.Review;
import org.cventbootcamp.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {
    private ReviewRepository reviewRepository;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository){
        this.reviewRepository = reviewRepository;
    }

    public List<Review> getAllReviews(){
        return this.reviewRepository.findAll();
    }

    public Optional<Review> getReviewById(Long id) {
        return this.reviewRepository.findById(id);
    }
}

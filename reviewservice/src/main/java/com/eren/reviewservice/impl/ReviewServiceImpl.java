package com.eren.reviewservice.impl;


import com.eren.reviewservice.ReviewService;
import com.eren.reviewservice.entity.Review;
import com.eren.reviewservice.repository.ReviewServiceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewServiceRepository repository;


    @Override
    public Review createReview(Review review) {
        return repository.save(review);
    }

    @Override
    public List<Review> getReviewByCompanyId(Long id) {
        return repository.findAllByCompanyId(id);
    }

    @Override
    public Review getReviewById(Long id) throws Exception {
        Review review= repository.findById(id).orElseThrow(
                ()-> new Exception("Review Not Found")
        );
        return review;
    }

    @Override
    public List<Review> getAllReviews() {
        return repository.findAll();
    }

    @Override
    public Review updateReview(Review review,Long id) throws Exception {
        Optional<Review> existingReview = repository.findById(id);
        if(existingReview.isPresent()){
            Review updatedReview = existingReview.get();
            updatedReview.setReviewerName(review.getReviewerName());
            updatedReview.setRating(review.getRating());
            updatedReview.setCompanyId(review.getCompanyId());
            updatedReview.setComment(review.getComment());
            return repository.save(updatedReview);
        }
        else{
            throw new Exception("Review Not found");
        }
    }

    @Override
    public Boolean deleteReview(Long id) throws Exception {
        Optional<Review> review=repository.findById(id);
        if(review.isPresent()){
            repository.deleteById(id);
        }else{
            throw new Exception("Review Not Found");
        }
        return true;
    }
}

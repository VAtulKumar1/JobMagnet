package com.eren.reviewservice;

import com.eren.reviewservice.entity.Review;

import java.util.List;

public interface ReviewService {
    Review createReview(Review review);

    List<Review> getReviewByCompanyId(Long id);

    Review getReviewById(Long id) throws Exception;

    List<Review> getAllReviews();

    Review updateReview(Review review,Long id) throws Exception;

    Boolean deleteReview(Long id) throws Exception;
}

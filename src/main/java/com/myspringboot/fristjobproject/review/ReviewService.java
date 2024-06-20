package com.myspringboot.fristjobproject.review;

import org.springframework.stereotype.Service;

import java.util.List;

public interface ReviewService {
    public List<Review> getAllReviewsByCompany(long compId);

    public boolean createReviewsForCompany(long compId, Review newReview);

    public Review getAReviewForCompany(long compId, long reviewId);

    public boolean updateReviewForCompany(Review review, long compId, long reviewId);

    public boolean deleteReviewForCompany(long compId, long reviewId);
}

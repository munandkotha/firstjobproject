package com.myspringboot.fristjobproject.review.impl;

import com.myspringboot.fristjobproject.company.Company;
import com.myspringboot.fristjobproject.company.CompanyService;
import com.myspringboot.fristjobproject.review.Review;
import com.myspringboot.fristjobproject.review.ReviewService;
import com.myspringboot.fristjobproject.review.repos.ReviewRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    private ReviewRepository reviewRepo;
    private CompanyService companyService;

    public ReviewServiceImpl(ReviewRepository reviewRepo, CompanyService companyService) {
        this.reviewRepo = reviewRepo;
        this.companyService = companyService;
    }

    @Override
    public List<Review> getAllReviewsByCompany(@PathVariable long compId) {
        return reviewRepo.findByCompanyId(compId);
    }

    @Override
    public boolean createReviewsForCompany(long compId, Review newReview) {
        Company company = companyService.findByCompanyId(compId);
        if(company != null) {
            newReview.setCompany(company);
            reviewRepo.save(newReview);
            return true;
        }
        return false;
    }

    @Override
    public Review getAReviewForCompany(long compId, long reviewId) {
        List<Review> reviews = reviewRepo.findByCompanyId(compId);
        return reviews.stream().filter(review -> review.getId() == reviewId).findFirst().orElse(null);
    }

    @Override
    public boolean updateReviewForCompany(Review newReview, long compId, long reviewId) {
        Review oldReview = reviewRepo.findById(reviewId).orElse(null);
        if(oldReview != null) {
            oldReview.setTitle(newReview.getTitle());
            oldReview.setDescription(newReview.getDescription());
            oldReview.setRating(newReview.getRating());
            reviewRepo.save(oldReview);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteReviewForCompany(long compId, long reviewId) {
        reviewRepo.deleteById(reviewId);
        return true;
    }
}

package com.myspringboot.fristjobproject.review;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies/{companyId}")
public class ReviewController {
      private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getAllReviews(@PathVariable long companyId) {
        return new ResponseEntity<>(reviewService.getAllReviewsByCompany(companyId), HttpStatus.OK);
    }

    @PostMapping("/reviews")
    public ResponseEntity<String> createReviewForCompany(@PathVariable long companyId,
                                                         @RequestBody Review newReview) {
        if(reviewService.createReviewsForCompany(companyId, newReview)) {
            return new ResponseEntity<>("Review created Successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Couldn't crate Review!", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/reviews/{reviewId}")
    public ResponseEntity<Review> getReviewForCompany(@PathVariable long companyId,
                                                      @PathVariable long reviewId) {
        Review review = reviewService.getAReviewForCompany(companyId, reviewId);
        if(review != null) {
            return new ResponseEntity<>(review, HttpStatus.OK);
        }
        return new ResponseEntity<>(new Review(), HttpStatus.NOT_FOUND);
    }

    @PutMapping("/reviews/{reviewId}")
    public ResponseEntity<String> updateReviewOfCompany(@RequestBody Review newReview,
                                                        @PathVariable long companyId,
                                                        @PathVariable long reviewId) {
        if(reviewService.updateReviewForCompany(newReview, companyId, reviewId)) {
            return new ResponseEntity<>("Review Updated Successfully!", HttpStatus.OK);
        }
        return new ResponseEntity<>("Couldn't find and update the Reivew!", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/reviews/{reviewId}")
    public ResponseEntity<String> deleteReviewForCompany(@PathVariable long companyId,
                                                         @PathVariable long reviewId) {
        if (reviewService.deleteReviewForCompany(companyId, reviewId)) {
            return new ResponseEntity<>("Deleted Review Successfully!", HttpStatus.OK);
        }
        return new ResponseEntity<>("Couldn't find the review!", HttpStatus.NOT_FOUND);
    }
}

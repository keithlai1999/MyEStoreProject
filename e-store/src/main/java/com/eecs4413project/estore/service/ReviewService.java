package com.eecs4413project.estore.service;

import com.eecs4413project.estore.entity.Review;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReviews();

    Review getReviewById(Long id);

    Review createReview(Review review);

    void deleteReview(Long id);

    List<Review> getReviewsByItemBid(String bid);
}

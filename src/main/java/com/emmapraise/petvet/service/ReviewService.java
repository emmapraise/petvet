package com.emmapraise.petvet.service;

import com.emmapraise.petvet.payload.ReviewDto;

import java.util.List;

public interface ReviewService {
    List<ReviewDto> getReviews();

    ReviewDto postReview(long ownerId, long appointmentId, ReviewDto reviewDto);

    String deleteReview(long reviewId);
}

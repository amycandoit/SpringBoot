package com.example.food.service;

import com.example.food.domain.entity.Review;
import com.example.food.domain.request.ReviewRequest;
import com.example.food.domain.request.ReviewUpdateRequest;
import com.example.food.domain.response.ReviewResponse;
import com.example.food.repository.ReviewRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ReviewService {
    private final ReviewRepository reviewRepository;

    public List<Review> findAllReview() {
        return reviewRepository.findAll();
    }

    public void saveReview(ReviewRequest reviewRequest) {
        reviewRepository.save(reviewRequest.toEntity());
    }

    public ReviewResponse updateReview(Long reviewSeq , ReviewUpdateRequest reviewUpdateRequest) {
        Review review = findById(reviewSeq);
        review.update(reviewUpdateRequest.getContent());
        return new ReviewResponse(review);
    }

    public void deleteReview(Long reviewSeq) {
        reviewRepository.deleteById(reviewSeq);
    }

    private Review findById(Long reviewSeq) {
        return reviewRepository.findById(reviewSeq).orElseThrow(()-> new RuntimeException());
    }


}

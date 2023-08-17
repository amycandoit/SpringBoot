package com.example.food.domain.response;

import com.example.food.domain.entity.Review;
import lombok.Getter;

@Getter
public class ReviewResponse {
    private String content;

    public ReviewResponse(Review review) {
        this.content = review.getContent();
    }
}

package com.example.food.domain.response;

import com.example.food.domain.entity.Comment;
import lombok.Getter;

@Getter
public class CommentResponse {
    private String content;

    public CommentResponse(Comment comment) {
        this.content = comment.getContent();
    }
}

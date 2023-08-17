package com.example.food.controller;

import com.example.food.domain.entity.Comment;
import com.example.food.domain.request.CommentRequest;
import com.example.food.domain.request.CommentUpdateRequest;
import com.example.food.domain.response.CommentResponse;
import com.example.food.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/comments")
@CrossOrigin("*")
public class CommentController {
    private final CommentService commentService;

    @GetMapping
    public List<Comment> findAllComment() {
        return commentService.findAllComment();
    }

    @PostMapping()
    public void saveComment(@RequestBody CommentRequest commentRequest) {
        commentService.saveComment(commentRequest);
    }

    @PutMapping("{commentSeq}")
    public CommentResponse updateComment(@PathVariable("commentSeq") Long commentSeq, @RequestBody CommentUpdateRequest commentUpdateRequest) {
        return commentService.updateComment(commentSeq, commentUpdateRequest);
    }

    @DeleteMapping("{commentSeq}")
    public void deleteComment(@PathVariable("commentSeq") Long commentSeq) {
        commentService.deleteComment(commentSeq);

    }


}

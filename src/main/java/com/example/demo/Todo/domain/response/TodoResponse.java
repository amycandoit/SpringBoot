package com.example.demo.Todo.domain.response;

import com.example.demo.Todo.domain.entity.Todo;
import com.example.demo.member.domain.dto.MemberDto;
import com.example.demo.member.domain.entity.Member;
import lombok.Getter;

import java.util.List;

@Getter
public class TodoResponse {
    private Long id;
    private String title;
    private String content;
    private boolean isDone;
    private int likeCount;
    private MemberDto member;

    public TodoResponse(Todo todo) {
        this.id = todo.getId();
        this.title = todo.getTitle();
        this.content = todo.getContent();
        this.isDone = todo.isDone();
        this.likeCount = todo.getLikeCount();
        this.member = new MemberDto(todo.getMember());

    }

}

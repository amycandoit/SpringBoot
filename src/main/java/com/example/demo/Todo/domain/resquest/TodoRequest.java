package com.example.demo.Todo.domain.resquest;

import com.example.demo.Todo.domain.entity.Todo;
import com.example.demo.member.domain.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TodoRequest {
    private String title;
    private String content;
//    private boolean isDone;
    private int likeCount;
    private Long memberId;

    public Todo toEntity() {
        return Todo.builder()
                .title(title)
                .content(content)
                .likeCount(likeCount)
                .member(Member.builder().id(memberId).build())
                .build();
    }
}

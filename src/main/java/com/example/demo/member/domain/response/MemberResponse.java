package com.example.demo.member.domain.response;

import com.example.demo.Todo.domain.dto.TodoDto;
import com.example.demo.Todo.domain.entity.Todo;
import com.example.demo.member.domain.dto.MemberDto;
import com.example.demo.member.domain.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
public class MemberResponse {
    private MemberDto member;
    private List<TodoDto> todos;

    public MemberResponse(Member member) {
        this.member = new MemberDto(member);
        this.todos = member.getTodos().stream()
                .map(TodoDto::new)
                .toList();
    }

}


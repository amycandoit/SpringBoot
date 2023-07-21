package com.example.demo.member.domain.reuqest;

import com.example.demo.Todo.domain.entity.Todo;
import com.example.demo.member.domain.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor @NoArgsConstructor
public class MemberRequest {
    private String email;
    private String password;
    private String name;
    private int age;

    public Member toEntity() {
        return new Member(email,password,name,age);
    }
}

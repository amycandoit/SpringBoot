package com.example.demo.member;

import lombok.*;

//@RequiredArgsConstructor //final 붙은것만 생성자 만들어줌
//@Getter
//@ToString
public record MemberRequest(String name, Integer age) {
    public Member toEntity() {
        return new Member(name, age);
    }
}

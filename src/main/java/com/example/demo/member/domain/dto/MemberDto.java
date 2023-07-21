package com.example.demo.member.domain.dto;

import com.example.demo.member.domain.entity.Member;
import lombok.Getter;

@Getter
public class MemberDto {
    private Long id;
    private String name;
    private Integer age;

    public MemberDto(Member member) {
        this.id = member.getId();
        this.name = member.getName();
        this.age = member.getAge();
    }
}

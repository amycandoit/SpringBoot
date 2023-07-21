package com.example.demo.member.domain.response;

import com.example.demo.member.domain.entity.Member;

public class LoginResponse {
    private Long id;
    private String name;
    private Integer age;

    public LoginResponse(Long id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public LoginResponse(Member member) {
        this.id = member.getId();
        this.name = member.getName();
        this.age = member.getAge();
    }
}

package com.example.demo.member.controller;

import com.example.demo.member.domain.entity.Member;
import com.example.demo.member.domain.response.LoginResponse;
import com.example.demo.member.domain.response.MemberResponse;
import com.example.demo.member.domain.reuqest.LoginRequest;
import com.example.demo.member.domain.reuqest.MemberRequest;
import com.example.demo.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/members")
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public void signup(@RequestBody MemberRequest memberRequest) {
       memberService.signup(memberRequest);
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest) {
        return memberService.login(loginRequest);
    }

    @GetMapping
    public Page<MemberResponse> findAll(
            @RequestParam(name = "size", required = false, defaultValue = "10") Integer size
            ,@RequestParam(name = "page", required = false, defaultValue = "0") Integer page) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return memberService.findAll(pageRequest);
    }
}

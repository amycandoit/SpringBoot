package com.example.demo.member.service;

import com.example.demo.member.domain.entity.Member;
import com.example.demo.member.domain.response.LoginResponse;
import com.example.demo.member.domain.response.MemberResponse;
import com.example.demo.member.domain.reuqest.LoginRequest;
import com.example.demo.member.domain.reuqest.MemberRequest;
import com.example.demo.member.repository.MemberRepository;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class MemberService {

    private final MemberRepository memberRepository;

    public Page<MemberResponse> findAll( PageRequest pageRequest) {
        Page<Member> all = memberRepository.findAll(pageRequest);
        return all.map(MemberResponse::new);
    }

    public void save(MemberRequest memberRequest) {
        Member save = memberRepository.save(memberRequest.toEntity());
    }

    public Member findById(Long id) {
        return memberRepository.findById(id).orElseThrow(() -> new RuntimeException());
//        Optional<Member> byId = memberRepository.findById(id);
//        Member member = byId.orElseThrow(() -> new RuntimeException("Not Found Member By " + id));
//        return new MemberResponse(member);
    }

    public void signup(MemberRequest memberRequest) {
        memberRepository.save(memberRequest.toEntity());
    }

    public LoginResponse login(LoginRequest loginRequest) {
        Member member = memberRepository
                .findByEmailAndPassword(
                        loginRequest.getEmail(),
                        loginRequest.getPassword())
                .orElseThrow(() -> new RuntimeException("그런 멤버 없다"));
        return new LoginResponse(member);
    }

}

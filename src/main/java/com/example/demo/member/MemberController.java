package com.example.demo.member;

import com.example.demo.User;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/members") //server를 부를때는 /api를 붙여줘야함
@RequiredArgsConstructor
public class MemberController {
//    @Autowired
    private final MemberService memberService;

    @GetMapping
    public List<Member> findAll(){
        return memberService.findAll();
    }

    @GetMapping("{id}")
    public Member findById(@PathVariable("id") Integer id) {
        return memberService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody MemberRequest member) {
        memberService.save(member.toEntity());
    }
    @PutMapping("{id}")
    public Member update(@PathVariable("id") Integer id
            ,@RequestBody MemberRequest request) {
        return memberService.update(id, request);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Integer id) {
        memberService.delete(id);
    }
}

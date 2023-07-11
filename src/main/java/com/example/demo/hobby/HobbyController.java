package com.example.demo.hobby;

import com.example.demo.member.Member;
import com.example.demo.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/hobbies") //server를 부를때는 /api를 붙여줘야함
@RequiredArgsConstructor
public class HobbyController {

    private final HobbyService hobbyService;
    private final MemberService memberService;

    @GetMapping
    public List<HobbyRequest> findHobbyAll() {
        return hobbyService.findHobbyAll();
    }

    @PostMapping
    public void insertHobby(@RequestParam String name, @RequestParam Integer memberId) {
        Member member = memberService.findById(memberId);
        hobbyService.insertHobby(name, member);
    }

}

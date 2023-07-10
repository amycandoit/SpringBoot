package com.example.demo.hobby;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/hobbies") //server를 부를때는 /api를 붙여줘야함
@RequiredArgsConstructor
public class HobbyController {

    private final HobbyService hobbyService;

}

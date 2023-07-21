package com.example.demo.Todo.domain.resquest;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UpdateRequest {
    private String title;
    private String content;
    private boolean isDone;

}

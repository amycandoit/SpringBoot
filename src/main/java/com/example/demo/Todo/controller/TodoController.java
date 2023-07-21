package com.example.demo.Todo.controller;

import com.example.demo.Todo.domain.response.TodoResponse;
import com.example.demo.Todo.domain.resquest.TodoRequest;
import com.example.demo.Todo.domain.resquest.UpdateRequest;
import com.example.demo.Todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/todos")
public class TodoController {
    private final TodoService todoService;

    @GetMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Page<TodoResponse> findAll(@RequestParam(name = "size", required = false, defaultValue = "20") Integer size
            , @RequestParam(name = "page", required = false, defaultValue = "0") Integer page) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return todoService.findAll(pageRequest);
    }

    @GetMapping("{title}")
    public List<TodoResponse> getByTitle(@PathVariable("title") String title) {
        return todoService.findByTitle(title);
    }

    @PostMapping
    public void save(@RequestBody TodoRequest todoRequest) {
        todoService.save(todoRequest);
    }

    @PutMapping("{id}")
    public TodoResponse update(@PathVariable("id") Long id, @RequestBody UpdateRequest updateRequest) {
        return todoService.update(id, updateRequest);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Long id) {
        todoService.delete(id);
    }

    @PostMapping("{todoId}/like/{memberId}")
    public void like(@PathVariable("todoId") Long todoId
            , @PathVariable("memberId") Long memberId) {
        todoService.like(todoId, memberId);
    }

}

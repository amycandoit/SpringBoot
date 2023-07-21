package com.example.demo.Todo.service;

import com.example.demo.Todo.domain.entity.Like;
import com.example.demo.Todo.domain.entity.Todo;
import com.example.demo.Todo.domain.response.TodoResponse;
import com.example.demo.Todo.domain.resquest.TodoRequest;
import com.example.demo.Todo.domain.resquest.UpdateRequest;
import com.example.demo.Todo.repository.LikeRepository;
import com.example.demo.Todo.repository.TodoRepository;
import com.example.demo.member.domain.entity.Member;
import com.example.demo.member.service.MemberService;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class TodoService {
    private final MemberService memberService;
    private final LikeRepository likeRepository;
    private final TodoRepository todoRepository;

    public Page<TodoResponse> findAll(PageRequest pageRequest) {
        Page<Todo> all = todoRepository.findAll(pageRequest);
        return all.map(TodoResponse::new);
    }

    public List<TodoResponse> findByTitle(String title) {
        return todoRepository.findAll()
                .stream()
                .filter(todo -> todo.getTitle().equals(title))
                .map(TodoResponse::new)
                .toList();
    }

    public void save(TodoRequest todoRequest) {
        Todo save = todoRepository.save(todoRequest.toEntity());
    }

    public void delete(Long id) {
        todoRepository.deleteById(id);
    }

    public TodoResponse update(Long id, UpdateRequest updateRequest) {
//        Optional<Todo> byId = todoRepository.findById(id);
//        if(byId.isEmpty()) throw new RuntimeException();
        Todo todo = findById(id);
        todo.update(updateRequest.getTitle(),updateRequest.getContent(), updateRequest.isDone());
        return new TodoResponse(todo);
    }

    public void like(Long todoId, Long memberId) {
        Todo todo = findById(todoId);
        Member member = memberService.findById(memberId);
        Like like = new Like(member, todo);
        todo.plusLikeCount();
        likeRepository.save(like);
    }

    public Todo findById(Long todoId) {
        return todoRepository
                .findById(todoId)
                .orElseThrow(() -> new RuntimeException());
    }

}

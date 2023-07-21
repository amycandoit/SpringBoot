package com.example.demo.Todo.repository;

import com.example.demo.Todo.domain.entity.Todo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;



public interface TodoRepository
        extends JpaRepository<Todo, Long> {
    Page<Todo> findAll(Pageable pageable);
}

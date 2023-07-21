package com.example.demo.Todo.repository;

import com.example.demo.Todo.domain.entity.Like;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Like, Long> {

}

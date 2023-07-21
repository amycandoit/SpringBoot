package com.example.demo.Todo.domain.dto;

import com.example.demo.Todo.domain.entity.Todo;
import lombok.AllArgsConstructor;
import lombok.Getter;
@Getter
public class TodoDto {
        private Long id;
        private String title;
        private String content;
        private boolean isDone;
        private int likeCount;


        public TodoDto(Todo todo) {
            this.id = todo.getId();
            this.title = todo.getTitle();
            this.content = todo.getContent();
            this.isDone = todo.isDone();
            this.likeCount = todo.getLikeCount();
        }

}


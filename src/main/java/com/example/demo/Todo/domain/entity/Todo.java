package com.example.demo.Todo.domain.entity;

import com.example.demo.member.domain.entity.Member;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Todos")
@Builder
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private boolean isDone;
    private int likeCount;
    @ManyToOne
    private Member member;

    public Todo(String title, String content, int likeCount) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.isDone = false;
        this.likeCount = likeCount;
    }

    public void update(String title, String content, boolean isDone) {
        this.title = title;
        this.content = content;
        this.isDone = isDone;
    }

    public void plusLikeCount() {
        this.likeCount++;
    }

}

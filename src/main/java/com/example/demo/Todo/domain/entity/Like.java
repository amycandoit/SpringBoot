package com.example.demo.Todo.domain.entity;

import com.example.demo.member.domain.entity.Member;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Likes")
@Builder
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Member member;
    @ManyToOne
    private Todo todo;

    public Like(Member member, Todo todo) {
        this.member = member;
        this.todo = todo;
    }
}

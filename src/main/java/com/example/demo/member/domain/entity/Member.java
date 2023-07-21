package com.example.demo.member.domain.entity;

import com.example.demo.Todo.domain.entity.Todo;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="members")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    private String name;
    private int age;
    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    private List<Todo> todos = new ArrayList<>();

    public Member(String email, String password, String name, int age) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.age = age;

    }

//    public Member(Long memberId) {
//        this.id = memberId;
//    }
}

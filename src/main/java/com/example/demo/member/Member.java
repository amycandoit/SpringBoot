package com.example.demo.member;

import com.example.demo.hobby.Hobby;
import com.example.demo.store.Store;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor @NoArgsConstructor
public class Member {
    private Integer id;
    private String name;
    private Integer age;
    private List<Hobby> hobbies = new ArrayList<>();

    public Member(String name, Integer age) {
        this.id = Store.memberIndex++;
        this.name = name;
        this.age = age;
    }
}

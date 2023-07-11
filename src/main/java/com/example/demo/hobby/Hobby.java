package com.example.demo.hobby;

import com.example.demo.member.Member;
import com.example.demo.store.Store;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class Hobby {
    private Integer id;
    private String name;
    private Member member;

    public Hobby(Integer id, String name, Member member) {
        this.id = Store.hobbyIndex++;
        this.name = name;
        this.member = member;
    }
}

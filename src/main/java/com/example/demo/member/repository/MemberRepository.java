package com.example.demo.member.repository;

import com.example.demo.member.domain.entity.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Page<Member> findAll(Pageable pageable);
    //fetch join 쿼리쓰기
//    @Query("select m from Member m left join fetch m.todos t join fetch t.todo ")

    Optional<Member> findByEmailAndPassword(String email, String password);
}

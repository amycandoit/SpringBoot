package com.example.demo.members.repository;

import com.example.demo.members.domain.dto.MemberCondition;
import com.example.demo.members.domain.response.MemberResponse;
import com.example.demo.members.domain.response.QMemberResponse;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import static com.example.demo.todos.domain.entity.QTodo.todo;
import static com.example.demo.members.domain.entity.QMember.member;

public class CustomMemberRepositoryImpl implements CustomMemberRepository {
    private final JPAQueryFactory queryFactory;

    public CustomMemberRepositoryImpl(EntityManager entityManager) {
        this.queryFactory = new JPAQueryFactory(entityManager);
    }
    @Override
    public Page<MemberResponse> findAllByName(
            PageRequest pageRequest,
            MemberCondition memberCondition) {
        JPAQuery<MemberResponse> query = queryFactory
                .select(new QMemberResponse(member))
                .from(member)
                .leftJoin(member.todos, todo)
                .fetchJoin()
                .where(nameStartWith(memberCondition.getName()),
                        isAgeGoe(memberCondition.getAgeGoe()),
                        isAgeLoe(memberCondition.getAgeLoe())
                )
                .offset(pageRequest.getPageNumber())
                .limit(pageRequest.getPageSize());

        List<MemberResponse> content = query.fetch();
        Long totalSize = queryFactory
                .select(member.count())
                .from(member)
                .where(nameStartWith(memberCondition.getName()),
                        isAgeGoe(memberCondition.getAgeGoe()),
                        isAgeLoe(memberCondition.getAgeLoe())
                ).fetchOne();
        return new PageImpl<>(content, pageRequest, totalSize);
    }

    private BooleanExpression nameStartWith(String memberCondition) {
        return memberCondition == null ? null : member.name.startsWith(memberCondition);
    }

    private BooleanExpression isAgeGoe(Integer ageGoe) {
        return ageGoe == null ? null : member.age.goe(ageGoe);
    }

    private BooleanExpression isAgeLoe(Integer ageLoe) {
        return ageLoe == null ? null : member.age.loe(ageLoe);
    }
}
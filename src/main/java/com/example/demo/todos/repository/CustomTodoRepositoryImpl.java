package com.example.demo.todos.repository;

//import com.example.demo.members.domain.entity.QMember;
import com.example.demo.todos.domain.dto.TodoCondition;
//import com.example.demo.todos.domain.entity.QTodo;
import com.example.demo.todos.domain.entity.Todo;
import com.example.demo.todos.domain.response.QTodoResponse;
import com.example.demo.todos.domain.response.TodoResponse;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import static com.example.demo.todos.domain.entity.QTodo.todo;
import static com.example.demo.members.domain.entity.QMember.member;

public class CustomTodoRepositoryImpl implements CustomTodoRepository {
    private final JPAQueryFactory queryFactory;
//    private final QTodo qTodo = QTodo.todo;
//    private final QMember qMember = QMember.member;

    public CustomTodoRepositoryImpl(EntityManager entityManager) {
        this.queryFactory = new JPAQueryFactory(entityManager);
    }
    @Override
    public Page<TodoResponse> findAllByCondition(
            PageRequest request,
            TodoCondition todoCondition) {
        JPAQuery<TodoResponse> query = queryFactory
                .select(new QTodoResponse(todo))
                .from(todo)
                .leftJoin(todo.member, member)
                .fetchJoin()
                .where(
                        contentContains(todoCondition.getContent()),
                        titleEq(todoCondition.getTitle()),
                        idDoneEq(todoCondition.getIsDone()),
                        isLikeGoe(todoCondition.getLikeGoe()),
                        isLikeLoe(todoCondition.getLikeLoe())
                )
                .offset(request.getPageNumber())
                .limit(request.getPageSize());

        List<TodoResponse> content = query.fetch();
        Long totalSize = queryFactory
                .select(todo.count())
                .from(todo)
                .where(
                        contentContains(todoCondition.getContent()),
                        titleEq(todoCondition.getTitle()),
                        idDoneEq(todoCondition.getIsDone()),
                        isLikeGoe(todoCondition.getLikeGoe()),
                        isLikeLoe(todoCondition.getLikeLoe())
                )
                .fetchOne();
        return new PageImpl<>(content,request,totalSize);
    }


    private BooleanExpression contentContains(String todoCondition) {
        return  todoCondition == null ? null : todo.content.contains(todoCondition);
    }

    private BooleanExpression titleEq(String title) {
        return title == null ? null : todo.title.eq(title);
    }

    private BooleanExpression idDoneEq(Boolean isDone) {
        return isDone == null ? null : todo.isDone.eq(isDone);
    }

    private BooleanExpression isLikeGoe(Integer likeGoe) {
        return likeGoe == null ? null : todo.likeCount.goe(likeGoe);
    }
    private BooleanExpression isLikeLoe(Integer likeLoe) {
        return likeLoe == null ? null : todo.likeCount.loe(likeLoe);
    }


}

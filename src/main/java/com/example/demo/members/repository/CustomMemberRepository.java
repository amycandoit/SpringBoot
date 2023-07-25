package com.example.demo.members.repository;

import com.example.demo.members.domain.dto.MemberCondition;
import com.example.demo.members.domain.response.MemberResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface CustomMemberRepository {
    Page<MemberResponse> findAllByName(PageRequest pageRequest,
                                       MemberCondition memberCondition);
}

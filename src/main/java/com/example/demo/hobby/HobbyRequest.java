package com.example.demo.hobby;

import com.example.demo.member.Member;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HobbyRequest{
  private String name;
  private Integer memberId;
}

//물고무는 관계를 끊기 위해
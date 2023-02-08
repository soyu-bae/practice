package com.magnumbridge.BOSS.member.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateMemberRequest {
    private String name;
    private Float age;
}

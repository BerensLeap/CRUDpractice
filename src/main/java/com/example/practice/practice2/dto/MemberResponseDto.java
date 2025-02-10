package com.example.practice.practice2.dto;

import lombok.Getter;

@Getter
public class MemberResponseDto {

    private final Long id;
    private final String name;

    public MemberResponseDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}

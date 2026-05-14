package com.example.ch4aws.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateMemberResponse {
    private String name;
    private int age;
    private String MBTI;
}

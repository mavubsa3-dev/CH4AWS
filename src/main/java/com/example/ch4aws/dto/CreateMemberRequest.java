package com.example.ch4aws.dto;

import lombok.Getter;

@Getter
public class CreateMemberRequest {
    private String name;
    private int age;
    private String MBTI;
}

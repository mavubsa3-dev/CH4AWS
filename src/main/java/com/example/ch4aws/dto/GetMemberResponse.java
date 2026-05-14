package com.example.ch4aws.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GetMemberResponse {
    private String name;
    private int age;
    private String MBTI;
}

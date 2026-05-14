package com.example.ch4aws.controller;

import com.example.ch4aws.dto.CreateMemberRequest;
import com.example.ch4aws.dto.CreateMemberResponse;
import com.example.ch4aws.dto.GetMemberResponse;
import com.example.ch4aws.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/members")
public class MemberController {
    private final MemberService memberService;

    @PostMapping
    public ResponseEntity<CreateMemberResponse> save(@RequestBody CreateMemberRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(memberService.save(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetMemberResponse> getOneMember(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(memberService.getMember(id));
    }
}

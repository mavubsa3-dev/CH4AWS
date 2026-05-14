package com.example.ch4aws.service;

import com.example.ch4aws.dto.CreateMemberRequest;
import com.example.ch4aws.dto.CreateMemberResponse;
import com.example.ch4aws.dto.GetMemberResponse;
import com.example.ch4aws.entity.Member;
import com.example.ch4aws.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public CreateMemberResponse save(CreateMemberRequest request) {
        Member member = new Member(request.getName(), request.getAge(), request.getMBTI());
        Member savedMember = memberRepository.save(member);
        return new CreateMemberResponse(
                savedMember.getName(),
                savedMember.getAge(),
                savedMember.getMBTI()
        );
    }

    @Transactional
    public GetMemberResponse getMember(Long memberId) {
        Member member = memberRepository.findById(memberId).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 팀원입니다.")
        );
        return new GetMemberResponse(
                member.getName(),
                member.getAge(),
                member.getMBTI()
        );
    }
}

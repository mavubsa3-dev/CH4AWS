package com.example.ch4aws.repository;

import com.example.ch4aws.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}

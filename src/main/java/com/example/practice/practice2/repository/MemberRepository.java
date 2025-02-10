package com.example.practice.practice2.repository;

import com.example.practice.practice2.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Long> {
}

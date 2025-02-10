package com.example.practice.practice2.service;

import com.example.practice.practice2.dto.MemberRequestDto;
import com.example.practice.practice2.dto.MemberResponseDto;
import com.example.practice.practice2.entity.Member;
import com.example.practice.practice2.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public MemberResponseDto save(MemberRequestDto dto) {
        Member member = new Member(dto.getName());
        Member savedMember = memberRepository.save(member);
        return new MemberResponseDto(savedMember.getId(), savedMember.getName());
    }

    @Transactional(readOnly = true)
    public List<MemberResponseDto> findAll() {
        List<Member> members = memberRepository.findAll();

        List<MemberResponseDto> dtos = new ArrayList<>();
        for (Member member : members) {
            dtos.add(new MemberResponseDto(member.getId(), member.getName()));
        }
        return dtos;
    }

    @Transactional(readOnly = true)
    public MemberResponseDto findById(Long id) {
        Member memo = memberRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Member not found")
        );
        return new MemberResponseDto(memo.getId(), memo.getName());
    }

    @Transactional
    public MemberResponseDto update(Long id, MemberRequestDto dto) {
        Member memo = memberRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Member not found")
        );
        memo.update(dto.getName());
        return new MemberResponseDto(memo.getId(), memo.getName());
    }

    @Transactional
    public void deleteById(Long id) {
        if(!memberRepository.existsById(id)) {
            throw new IllegalArgumentException("Member not found");
        }
        memberRepository.deleteById(id);
    }
}

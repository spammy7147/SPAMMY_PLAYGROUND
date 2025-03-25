package com.chat.chatserver.member.service;

import com.chat.chatserver.member.domain.Member;
import com.chat.chatserver.member.dto.MemberLoginReqDto;
import com.chat.chatserver.member.dto.MemberResDto;
import com.chat.chatserver.member.dto.MemberSaveReqDto;
import com.chat.chatserver.member.repository.MemberRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public Member create(MemberSaveReqDto memberSaveReqDto) {
        if(memberRepository.findByEmail(memberSaveReqDto.getEmail()).isPresent()) {
            throw new IllegalArgumentException("이미 존재하는 이메일 입니다.");
        }
        return memberRepository.save(Member.builder()
                .name(memberSaveReqDto.getName())
                .email(memberSaveReqDto.getEmail())
                .password(passwordEncoder.encode(memberSaveReqDto.getPassword()))
                .build());
    }

    public Member login(MemberLoginReqDto memberLoginReqDto) {
        Member member = memberRepository.findByEmail(memberLoginReqDto.getEmail()).orElseThrow(() -> new EntityNotFoundException("존재하지 않는 이메일입니다."));

        if (!passwordEncoder.matches(memberLoginReqDto.getPassword(), member.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }
        return member;
    }

    public List<MemberResDto> findAll() {
        List<Member> members = memberRepository.findAll();
        return members.stream()
                .map(member -> new MemberResDto(member.getId(),member.getName(),member.getEmail()))
                .collect(Collectors.toList());
    }
}

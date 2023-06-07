package com.octagnosis.api.member.service;

import com.octagnosis.api.member.domain.Member;
import com.octagnosis.api.member.dto.MemberResponseDto;
import com.octagnosis.api.member.repository.MemberRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class MemberService implements UserDetailsService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member member = memberRepository.findByAccount(username).orElseThrow(() -> new UsernameNotFoundException("일치하는 회원이 없습니다."));
        return member;
    }

    public List<MemberResponseDto.Summary> findAll() {
        List<Member> memberList = memberRepository.findAll();
        return memberList.stream().map(member -> modelMapper.map(member, MemberResponseDto.Summary.class)).collect(Collectors.toList());
    }
}

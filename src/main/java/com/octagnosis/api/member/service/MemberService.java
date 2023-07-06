package com.octagnosis.api.member.service;

import com.octagnosis.api.member.domain.Member;
import com.octagnosis.api.member.dto.MemberDto;
import com.octagnosis.api.member.repository.MemberRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class MemberService implements UserDetailsService {

    @Autowired
    ModelMapper modelMapper;
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return memberRepository.findByAccount(username).orElseThrow(() -> new UsernameNotFoundException("일치하는 회원이 없습니다."));
    }

    public List<MemberDto.Response> findAll() {
        List<Member> memberList = memberRepository.findAll();
        return memberList.stream().map(member -> modelMapper.map(member, MemberDto.Response.class)).collect(Collectors.toList());
    }

    public boolean checkPassword(String inputPassword, String memberPassword) {
        return passwordEncoder.matches(inputPassword, memberPassword);
    }
}

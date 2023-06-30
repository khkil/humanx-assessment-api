package com.octagnosis.api.auth.service;

import com.octagnosis.api.auth.dto.JwtTokenDto;
import com.octagnosis.api.member.domain.Member;
import com.octagnosis.api.member.domain.MemberRole;
import com.octagnosis.api.member.dto.MemberRequestDto;
import com.octagnosis.api.member.repository.MemberRepository;
import com.octagnosis.api.member.service.MemberService;
import com.octagnosis.security.cookie.CookieUtil;
import com.octagnosis.security.jwt.JwtTokenUtil;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    ModelMapper modelMapper;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    JwtTokenUtil jwtTokenUtil;
    @Autowired
    CookieUtil cookieUtil;
    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;

    public JwtTokenDto login(String account, String password) {

        Member member = (Member) memberService.loadUserByUsername(account);
        if(!memberService.checkPassword(password, member.getPassword())) {
            throw new BadCredentialsException("비밀번호가 일치하지 않습니다.");
        }

        MemberRole role = member.getRole();

        String accessToken = jwtTokenUtil.createAccessToken(account, role);
        String refreshToken = jwtTokenUtil.createRefreshToken(account, role);

        return new JwtTokenDto(accessToken);

    }

    public Member signUp(MemberRequestDto memberRequestDto) {
        MemberRequestDto memberDto = MemberRequestDto.builder()
                .account(memberRequestDto.getAccount())
                .password(passwordEncoder.encode(memberRequestDto.getPassword()))
                /*.groupIdx(member.getGroupIdx())
                .name(member.getName())
                .email(member.getEmail())
                .phone(member.getPhone())
                .address(member.getAddress())
                .addressSub(member.getAddressSub())
                .school(member.getSchool())
                .education(member.getEducation())
                .grade(member.getGrade())
                .major(member.getMajor())
                .job(member.getJob())
                .company(member.getCompany())
                .jobDetail(member.getJobDetail())
                .cDate(member.getCDate())*/
                .build();
        Member member = modelMapper.map(memberDto, Member.class);
        memberRepository.save(member);
        return member;
    }
}

package com.octagnosis.api.auth.service;

import com.octagnosis.api.auth.dto.JwtTokenDto;
import com.octagnosis.api.user.entity.Member;
import com.octagnosis.api.user.entity.RoleEnum;
import com.octagnosis.api.user.dto.MemberSignupDto;
import com.octagnosis.api.user.repository.MemberRepository;
import com.octagnosis.api.user.service.UserService;
import com.octagnosis.security.cookie.CookieUtil;
import com.octagnosis.security.jwt.JwtTokenUtil;
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
    UserService userService;
    @Autowired
    MemberRepository memberRepository;

    public JwtTokenDto login(String account, String password) {

        Member member = (Member) userService.loadUserByUsername(account);
        if (!userService.checkPassword(password, member.getPassword())) {
            throw new BadCredentialsException("비밀번호가 일치하지 않습니다.");
        }

        RoleEnum role = member.getRole();

        String accessToken = jwtTokenUtil.createAccessToken(account, role);
        String refreshToken = jwtTokenUtil.createRefreshToken(account, role);

        return new JwtTokenDto(accessToken);
    }

    public Member signUp(MemberSignupDto.Request memberSignupDto) {
        MemberSignupDto.Request memberDto = MemberSignupDto.Request.builder()
                .account(memberSignupDto.getAccount())
                .password(passwordEncoder.encode(memberSignupDto.getPassword()))
                .role(RoleEnum.USER) // 회원가입은 USER 권한
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

package com.octagnosis.api.user.service;

import com.octagnosis.api.user.entity.UserPrivacy;
import com.octagnosis.api.user.dto.UserPrivacyDto;
import com.octagnosis.api.user.repository.MemberRepository;
import com.octagnosis.api.user.repository.UserPrivacyRepository;
import com.octagnosis.api.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final MemberRepository memberRepository;
    private final UserRepository userRepository;
    private final UserPrivacyRepository userPrivacyRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return memberRepository.findByAccount(username).orElseThrow(() -> new UsernameNotFoundException("일치하는 회원이 없습니다."));
    }

    public void saveUserPrivacy(Long userIdx, UserPrivacyDto.Request params) {
        UserPrivacy userPrivacy = UserPrivacy
                .builder()
                .user(userRepository.getReferenceById(userIdx))
                .userName(params.getUserName())
                .userEmail(params.getUserEmail())
                .userPhone(params.getUserPhone())
                .userBirth(params.getUserBirth())
                .build();

        userPrivacyRepository.save(userPrivacy);
    }

    public boolean checkPassword(String inputPassword, String memberPassword) {
        return passwordEncoder.matches(inputPassword, memberPassword);
    }
}

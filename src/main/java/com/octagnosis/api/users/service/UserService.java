package com.octagnosis.api.users.service;

import com.octagnosis.api.assessments.entity.AssessmentQuestion;
import com.octagnosis.api.assessments.repository.AssessmentAnswerRepository;
import com.octagnosis.api.assessments.repository.AssessmentQuestionRepository;
import com.octagnosis.api.terms.repository.PrivacyTermsRepository;
import com.octagnosis.api.users.dto.UserRegisterDto;
import com.octagnosis.api.users.entity.User;
import com.octagnosis.api.users.entity.UserAnswer;
import com.octagnosis.api.users.entity.UserPrivacy;
import com.octagnosis.api.users.dto.UserPrivacyDto;
import com.octagnosis.api.users.entity.UserPrivacyTermsAgreement;
import com.octagnosis.api.users.repository.MemberRepository;
import com.octagnosis.api.users.repository.UserPrivacyRepository;
import com.octagnosis.api.users.repository.UserPrivacyTermsAgreementRepository;
import com.octagnosis.api.users.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;


@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final MemberRepository memberRepository;
    private final UserRepository userRepository;
    private final UserPrivacyRepository userPrivacyRepository;
    private final UserPrivacyTermsAgreementRepository userPrivacyTermsAgreementRepository;
    private final PrivacyTermsRepository privacyTermsRepository;
    private final AssessmentQuestionRepository assessmentQuestionRepository;
    private final AssessmentAnswerRepository assessmentAnswerRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return memberRepository.findByAccount(username).orElseThrow(() -> new UsernameNotFoundException("일치하는 회원이 없습니다."));
    }

    @Transactional
    public UserRegisterDto.Response registerUser(UserRegisterDto.Request userRegisterDto) {
        List<UserAnswer> userAnswers = userRegisterDto.getUserAnswers().stream().map(v -> UserAnswer
                .builder()
                .question(assessmentQuestionRepository.getReferenceById(v.getQuestionId()))
                .answer(assessmentAnswerRepository.getReferenceById(v.getAnswerId()))
                .build()
        ).toList();
        
        User user = userRepository.save(User
                .builder()
                .userName(userRegisterDto.getUserName())
                .userEmail(userRegisterDto.getUserEmail())
                .userBirth(userRegisterDto.getUserBirth())
                .userPhone(userRegisterDto.getUserPhone())
                .userAnswers(userAnswers)
                .build()
        );

        return UserRegisterDto.Response
                .builder()
                .userIdx(user.getUserIdx())
                .build();
    }

    @Transactional
    public void saveUserPrivacy(Long userIdx, UserPrivacyDto.Request params) {
        User user = userRepository.getReferenceById(userIdx);

        UserPrivacy userPrivacy = UserPrivacy
                .builder()
                .user(user)
                .userName(params.getUserName())
                .userEmail(params.getUserEmail())
                .userPhone(params.getUserPhone())
                .userBirth(params.getUserBirth())
                .build();

        userPrivacyRepository.save(userPrivacy);

        List<UserPrivacyTermsAgreement> termsAgreements = params.getTermsAgreements().stream().map(
                v -> UserPrivacyTermsAgreement
                        .builder()
                        .user(user)
                        .isAgreed(v.getIsAgreed())
                        .privacyTerms(privacyTermsRepository.getReferenceById(v.getTermsIdx()))
                        .agreementDate(LocalDateTime.now())
                        .build()
        ).toList();

        userPrivacyTermsAgreementRepository.saveAll(termsAgreements);

    }


    public boolean checkPassword(String inputPassword, String memberPassword) {
        return passwordEncoder.matches(inputPassword, memberPassword);
    }
}

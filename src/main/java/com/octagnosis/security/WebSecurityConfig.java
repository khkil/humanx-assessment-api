package com.octagnosis.security;

import com.octagnosis.api.member.domain.MemberRole;
import com.octagnosis.api.member.service.MemberService;
import com.octagnosis.security.cookie.CookieUtil;
import com.octagnosis.security.jwt.JwtAuthenticationEntryPoint;
import com.octagnosis.security.jwt.JwtTokenFilter;
import com.octagnosis.security.jwt.JwtTokenUtil;
import jakarta.servlet.DispatcherType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Autowired
    JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    @Autowired
    MemberService memberService;
    @Autowired
    JwtTokenUtil jwtTokenUtil;
    @Autowired
    CookieUtil cookieUtil;

    private static final String[] AUTH_WHITE_LIST = {
            "/api/auth/**", "/api/inspections/**"
    };
    private static final String[] AUTH_ADMIN_LIST = {
            "/api/admin/**"
    };

    @Bean
    protected SecurityFilterChain config(HttpSecurity http) throws Exception {

        return http
                .csrf().disable()
                .cors().disable()
                .authorizeHttpRequests(authorize -> authorize
                        .dispatcherTypeMatchers(DispatcherType.ERROR, DispatcherType.ASYNC)
                        .permitAll()
                        .requestMatchers(AUTH_WHITE_LIST)
                        .permitAll()
                        .requestMatchers(AUTH_ADMIN_LIST)
                        .hasAuthority(MemberRole.ADMIN.getRole())
                        .anyRequest()
                        .authenticated())
                .addFilterBefore(new JwtTokenFilter(memberService, jwtTokenUtil, cookieUtil), UsernamePasswordAuthenticationFilter.class)
                .build();
    }
}

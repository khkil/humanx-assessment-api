package com.octagnosis.api.member.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@DynamicUpdate
public class Member implements UserDetails{
    @Id
    @Column(name = "idx", nullable = false)
    private Long id;

    @Convert(converter = MemberRoleConverter.class)
    private MemberRole role;

    private Integer groupIdx;

    private String account;

    private String password;

    private String name;

    private String email;

    private String phone;

    private String address;

    private String addressSub;

    private String school;

    private String education;

    private Integer grade;

    private String major;

    private String job;

    private String company;

    private String jobDetail;

    @Column(name = "c_date", nullable = false, updatable = false)
    @CreationTimestamp
    private Date createdDate;

    private String modifiedDate;

    private boolean deleted;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collect = new ArrayList<>();
        if(role != null){
            collect.add(new SimpleGrantedAuthority(role.getRole()));
        }
        return collect;
    }

    @Override
    public String getUsername() {
        return account;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
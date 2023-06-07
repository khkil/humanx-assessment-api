package com.octagnosis.api.member.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MemberRole {
    USER("ROLE_USER", "회원"),
    ADMIN("ROLE_ADMIN", "관리자");


    private String role;
    private String desc;

    public String getRole(){
        return this.role;
    }
}

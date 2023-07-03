package com.octagnosis.api.member.dto;

import com.octagnosis.api.member.domain.RoleEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class MemberRequestDto {

    private String account;
    private String password;
    private RoleEnum role;
}

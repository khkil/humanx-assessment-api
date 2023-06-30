package com.octagnosis.api.member.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class MemberRequestDto {

    private String account;
    private String password;
}

package com.octagnosis.api.user.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class Guest {
    @Id
    private Long userIdx;
}

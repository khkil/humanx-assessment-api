package com.octagnosis.api.users.repository;

import com.octagnosis.api.users.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositoryCustom {
    Long countByAssessmentId(Long assessmentId);

}

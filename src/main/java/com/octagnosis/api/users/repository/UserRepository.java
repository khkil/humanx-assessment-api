package com.octagnosis.api.users.repository;

import com.octagnosis.api.assessments.entity.Assessment;
import com.octagnosis.api.users.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>, UserRepositoryCustom {
    Long countByInspectionIdx(long inspectionIdx);
}

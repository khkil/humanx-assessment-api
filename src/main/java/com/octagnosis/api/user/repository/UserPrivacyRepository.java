package com.octagnosis.api.user.repository;

import com.octagnosis.api.user.entity.UserPrivacy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPrivacyRepository extends JpaRepository<UserPrivacy, Long> {

}

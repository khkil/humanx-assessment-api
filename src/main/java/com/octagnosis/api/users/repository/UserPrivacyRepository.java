package com.octagnosis.api.users.repository;

import com.octagnosis.api.users.entity.UserPrivacy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPrivacyRepository extends JpaRepository<UserPrivacy, Long> {

}

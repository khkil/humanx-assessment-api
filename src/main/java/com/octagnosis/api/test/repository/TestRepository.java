package com.octagnosis.api.test.repository;

import com.octagnosis.api.test.domain.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<Test, Long> {

}

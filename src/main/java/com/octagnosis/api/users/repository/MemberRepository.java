package com.octagnosis.api.users.repository;

import com.octagnosis.api.users.entity.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findById(Long id);

    Optional<Member> findByAccount(String id);

    Optional<Member> findByEmail(String email);

    Page<Member> findByNameContaining(String name, Pageable pageable);
}

package com.octagnosis.api.inspection.repository;

import com.octagnosis.api.inspection.domain.Inspection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InspectionRepository extends JpaRepository<Inspection, Long> {
    
}

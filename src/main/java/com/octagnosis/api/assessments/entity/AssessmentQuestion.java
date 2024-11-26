package com.octagnosis.api.assessments.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.octagnosis.api.users.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AssessmentQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionId;

    private String questionTitle;

    private Integer questionNumber;

    private Integer questionPage;

    private Boolean isDeleted;

    @ManyToOne
    @JoinColumn(name = "assessment_id")
    private Assessment assessment;

    @ManyToOne
    @JoinColumn(name = "result_id")
    private AssessmentResult assessmentResult;
}

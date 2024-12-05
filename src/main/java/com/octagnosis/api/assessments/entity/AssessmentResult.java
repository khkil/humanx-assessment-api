package com.octagnosis.api.assessments.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AssessmentResult {
    @Id
    private Long resultId;

    private String resultName;

    @ManyToOne
    private Assessment assessment;

    @OneToMany(mappedBy = "assessmentResult")
    List<AssessmentResultContent> resultContentList;

    @OneToMany(mappedBy = "assessmentResult")
    List<AssessmentQuestion> questionList;
}

package com.octagnosis.api.assessments.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.octagnosis.api.assessments.enums.ContentType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AssessmentResultContent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contentId;

    private ContentType contentType;

    @Column(columnDefinition = "LONGTEXT")
    private String content;

    @ManyToOne
    @JoinColumn(name = "result_id")
    @JsonIgnore
    private AssessmentResult assessmentResult;
}

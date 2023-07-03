package com.octagnosis.api.result.domain;

import com.octagnosis.api.contents.domain.Contents;
import com.octagnosis.api.inspection.domain.Inspection;
import com.octagnosis.api.question.domain.Question;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Result {
    @Id
    private Long id;
    private String resultName;
    @ManyToOne
    private Inspection inspection;

    @OneToMany(mappedBy = "result")
    private List<Question> questionList;
    @OneToMany(mappedBy = "result")
    private List<Contents> contents;

}
package com.octagnosis.api.result.domain;

import com.octagnosis.api.contents.domain.Contents;
import com.octagnosis.api.question.domain.Question;
import com.octagnosis.api.test.domain.Test;
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
    private Test test;

    @OneToMany(mappedBy = "result")
    private List<Question> questionList;
    @OneToMany(mappedBy = "result")
    private List<Contents> contents;

}
package com.octagnosis.api.question.domain;

import com.octagnosis.api.result.domain.Result;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Question {

    @Id
    private Long id;
    private String questionPage;
    private int questionNumber;
    @ManyToOne
    private Result result;

}
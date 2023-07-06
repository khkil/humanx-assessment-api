package com.octagnosis.api.test.domain;

import com.octagnosis.api.result.domain.Result;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Test {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String testName;
    private boolean isShow;
    @OneToMany(mappedBy = "test")
    List<Result> resultList;
}

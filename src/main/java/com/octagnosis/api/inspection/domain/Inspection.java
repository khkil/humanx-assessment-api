package com.octagnosis.api.inspection.domain;

import com.octagnosis.api.result.domain.Result;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Inspection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String inspectionName;
    private boolean isShow;
    @OneToMany(mappedBy = "inspection")
    List<Result> resultList;
}

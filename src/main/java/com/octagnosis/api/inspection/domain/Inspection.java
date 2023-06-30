package com.octagnosis.api.inspection.domain;

import jakarta.persistence.*;

@Entity
public class Inspection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String inspectionName;
    private boolean isShow;

}

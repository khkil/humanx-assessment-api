package com.octagnosis.api.contents.domain;

import com.octagnosis.api.result.domain.Result;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Contents {
    @Id
    private Long id;
    @Convert(converter = ContentTypeEnumConverter.class)
    private ContentTypeEnum contentType;
    @ManyToOne
    private Result result;
}
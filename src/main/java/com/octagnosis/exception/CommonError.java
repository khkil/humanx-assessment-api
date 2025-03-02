package com.octagnosis.exception;

import org.springframework.http.HttpStatus;

public interface CommonError {

    HttpStatus getStatus();

    String getCode();

    String getMessage();
}

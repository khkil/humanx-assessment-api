package com.octagnosis.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ServiceError implements CommonError {
    // HTTP 오류
    OK(HttpStatus.OK, "20000", "success"),
    NOT_MODIFIED(HttpStatus.OK, "30004", HttpStatus.NOT_MODIFIED.getReasonPhrase()),
    BAD_REQUEST(HttpStatus.BAD_REQUEST, "40000", HttpStatus.BAD_REQUEST.getReasonPhrase()),
    UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "40001", HttpStatus.UNAUTHORIZED.getReasonPhrase()),
    FORBIDDEN(HttpStatus.FORBIDDEN, "40003", HttpStatus.FORBIDDEN.getReasonPhrase()),
    NOT_FOUND(HttpStatus.NOT_FOUND, "40004", HttpStatus.NOT_FOUND.getReasonPhrase()),
    METHOD_NOT_ALLOWED(HttpStatus.METHOD_NOT_ALLOWED, "40005", HttpStatus.METHOD_NOT_ALLOWED.getReasonPhrase()),
    NOT_ACCEPTABLE(HttpStatus.NOT_ACCEPTABLE, "40006", HttpStatus.NOT_ACCEPTABLE.getReasonPhrase()),
    CONFLICT(HttpStatus.CONFLICT, "40009", HttpStatus.CONFLICT.getReasonPhrase()),
    UNSUPPORTED_MEDIA_TYPE(HttpStatus.UNSUPPORTED_MEDIA_TYPE, "40015", HttpStatus.UNSUPPORTED_MEDIA_TYPE.getReasonPhrase()),
    SERVICE_UNAVAILABLE(HttpStatus.SERVICE_UNAVAILABLE, "50003", HttpStatus.SERVICE_UNAVAILABLE.getReasonPhrase()),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "50000", HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());

    private final HttpStatus status;
    private final String code;
    private final String message;
}

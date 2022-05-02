package com.qerat.employee.employee.api.exception;

import org.springframework.http.HttpStatus;
import java.time.LocalDateTime;

public class HttpException extends RuntimeException {

    private HttpStatus status;

    private final LocalDateTime timestamp;

    private String message;

    public HttpException() {
        timestamp = LocalDateTime.now();
        status = HttpStatus.FORBIDDEN;
    }

    public HttpException(HttpStatus status) {
        this();
        this.status = status;
    }

    public HttpException(HttpStatus status, String message) {
        this(status);
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    @Override
    public String getMessage() {
        return message;
    }

}

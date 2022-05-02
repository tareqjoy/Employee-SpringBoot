package com.qerat.employee.employee.api.exception;

import com.qerat.employee.employee.model.ErrorDto;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;


@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(HttpException.class)
    public ResponseEntity<ErrorDto> handleCityNotFoundException(
            HttpException ex, HttpServletRequest httpServletRequest) {

        return new ResponseEntity<>(
                new ErrorDto.Builder()
                        .timestamp(ex.getTimestamp())
                        .httpStatus(ex.getStatus())
                        .message(ex.getMessage())
                        .path(httpServletRequest.getRequestURI())
                        .build(),
                ex.getStatus()
        );
    }

}


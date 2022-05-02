package com.qerat.employee.employee.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;

import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorDto {
    @Nullable
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @JsonProperty("timestamp")
    private LocalDateTime timestamp;

    @Nullable
    @JsonProperty("status")
    private Integer status;

    @Nullable
    @JsonProperty("error")
    private String error;

    @Nullable
    @JsonProperty("message")
    private String message;

    @Nullable
    @JsonProperty("path")
    private String path;

    public static class Builder {
        private LocalDateTime timestamp;
        private Integer status;
        private String error;
        private String message;
        private String path;

        public Builder timestamp(LocalDateTime timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public Builder status(Integer status) {
            this.status = status;
            return this;
        }

        public Builder error(String error) {
            this.error = error;
            return this;
        }

        public Builder message(String message) {
            this.message = message;
            return this;
        }

        public Builder path(String path) {
            this.path = path;
            return this;
        }

        public Builder httpStatus(HttpStatus httpStatus) {
            this.status = httpStatus.value();
            this.error = httpStatus.getReasonPhrase();
            return this;
        }

        public ErrorDto build() {
            ErrorDto errorDto = new ErrorDto();
            errorDto.timestamp = timestamp;
            errorDto.status = status;
            errorDto.error = error;
            errorDto.message = message;
            errorDto.path = path;
            return errorDto;
        }
    }

    private ErrorDto() {

    }

    @Nullable
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    @Nullable
    public Integer getStatus() {
        return status;
    }

    @Nullable
    public String getError() {
        return error;
    }

    @Nullable
    public String getMessage() {
        return message;
    }

    @Nullable
    public String getPath() {
        return path;
    }

}

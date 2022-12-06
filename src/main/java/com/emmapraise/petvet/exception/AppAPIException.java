package com.emmapraise.petvet.exception;

import org.springframework.http.HttpStatus;

public class AppAPIException extends RuntimeException {

    private final HttpStatus status;
    private final String message;

    public AppAPIException(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public AppAPIException(String message, HttpStatus status, String message1) {
        super(message);
        this.status = status;
        this.message = message1;
    }

    public HttpStatus getStatus() {
        return status;
    }

    @Override
    public String getMessage() {
        return message;
    }
}

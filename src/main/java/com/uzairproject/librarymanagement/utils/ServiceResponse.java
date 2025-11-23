package com.uzairproject.librarymanagement.utils;

import org.springframework.http.HttpStatus;

public class ServiceResponse {
    private final HttpStatus code;
    private final String message;

    public ServiceResponse(HttpStatus code, String message){
        this.code = code;
        this.message = message;
    }

    public HttpStatus getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}

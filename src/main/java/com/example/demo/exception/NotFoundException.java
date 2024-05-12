package com.example.demo.exception;

import com.example.demo.Response.ApiErrorResponse;
import org.springframework.http.HttpStatus;

public class NotFoundException extends CarManagementApiException{

    private static final String NOT_FOUND_ACTION = "Resource should be created first";
    NotFoundException(HttpStatus httpStatus, ApiErrorResponse response) {
        super(httpStatus, response);
    }
}

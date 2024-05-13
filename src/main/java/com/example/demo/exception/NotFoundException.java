package com.example.demo.exception;

import com.example.demo.Response.ApiErrorResponse;
import org.springframework.http.HttpStatus;

public class NotFoundException extends CarManagementApiException{

    private static final String NOT_FOUND_ACTION = "Resource should be created first";

    public NotFoundException(String resource, String resourceId)
    {
        super(HttpStatus.NOT_FOUND, ApiErrorResponse.builder()
                .title(HttpStatus.NOT_FOUND.getReasonPhrase())
                .status(String.valueOf(HttpStatus.NOT_FOUND.value()))
                .cause(String.format("Resource '%s' couldn't be found by id'%s'",resource,resourceId))
                .action(NOT_FOUND_ACTION).build()
        );
    }
}

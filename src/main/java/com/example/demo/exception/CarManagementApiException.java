package com.example.demo.exception;

import com.example.demo.Response.ApiErrorResponse;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
@Getter
public class CarManagementApiException extends RuntimeException{
    private final HttpStatus httpStatus;
    private final ApiErrorResponse response;
}

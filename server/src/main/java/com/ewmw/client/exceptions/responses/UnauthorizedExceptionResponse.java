package com.ewmw.client.exceptions.responses;

import org.springframework.http.HttpStatus;

public class UnauthorizedExceptionResponse extends ApiErrorResponse{
    public UnauthorizedExceptionResponse() {
        this.message = "Unauthorized";
        this.responseStatusCode = HttpStatus.UNAUTHORIZED;
    }
}

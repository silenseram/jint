package com.ewmw.client.exceptions.advices;

import com.ewmw.client.exceptions.responses.CannotGetLogsResponse;
import com.ewmw.client.exceptions.responses.MethodArgumentNotValidResponse;
import com.ewmw.client.services.logs.CannotGetLogsException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

public class CannotGetLogsAdvice {

    @ResponseBody
    @ExceptionHandler(CannotGetLogsException.class)
    ResponseEntity<CannotGetLogsResponse> handle(CannotGetLogsException ex) {
        CannotGetLogsResponse response = new CannotGetLogsResponse();

        return new ResponseEntity<>(response, response.getResponseStatusCode());
    }
}

package com.ewmw.client.http.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class LogsSavingResponse {
    @Getter
    String message;

    @Getter
    boolean logSaved;
}

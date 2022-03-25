package com.ewmw.client.http.resposes;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class LogsSavingResponse {
    @Getter
    String message;

    @Getter
    boolean logSaved;
}

package com.ewmw.client.exceptions.responses;

public class CannotGetLogsResponse extends ApiErrorResponse {
    public CannotGetLogsResponse() {
        this.message = "Cannot get logs, please contact to us";
    }
}
